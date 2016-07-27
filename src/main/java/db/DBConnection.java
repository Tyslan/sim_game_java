package db;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import elements.Building;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lorenz on 27/07/2016.
 */
public class DBConnection {
    private static MongoClient mongoClient = new MongoClient();
    private static MongoDatabase db = mongoClient.getDatabase("sim-game");

    public static List<Building> getAllBuildings(){
        FindIterable<Document> iterable = db.getCollection("buildings").find();
        final List<Building> buildings = new ArrayList<>();
        iterable.forEach(new Block<Document>() {
            public void apply(final Document document) {
                Building building = parseDocumentToBuilding(document);
                buildings.add(building);
            }
        });

        return buildings;
    }

    private static Building parseDocumentToBuilding(Document document){
        String name = document.getString("name");
        int basePopulation = document.getInteger("basePopulation");
        int baseTourists = document.getInteger("baseTourists");
        int baseIncome = document.getInteger("baseIncome");
        int turnPopulation = document.getInteger("turnPopulation");
        int turnTourists = document.getInteger("turnTourists");
        int turnIncome = document.getInteger("turnIncome");
        int price = document.getInteger("price");

        return new Building(name, basePopulation, baseTourists, baseIncome,
                turnPopulation, turnTourists, turnIncome, price);
    }
}
