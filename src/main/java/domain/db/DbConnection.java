package domain.db;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import domain.elements.Building;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lorenz on 27/07/2016.
 */
public class DbConnection {
    private static MongoClientURI uri = new MongoClientURI(DbConfig.MONGO_URI);
    private static MongoClient mongoClient = new MongoClient(uri);
    private static MongoDatabase db = mongoClient.getDatabase(uri.getDatabase());

//    private static MongoClient mongoClient = new MongoClient();
//    private static MongoDatabase db = mongoClient.getDatabase("sim-game");

    public static Map<ObjectId, Building> getAllBuildings() {
        FindIterable<Document> iterable = db.getCollection("buildings").find();
        final Map<ObjectId, Building> buildings = new HashMap<>();
        iterable.forEach(new Block<Document>() {
            public void apply(final Document document) {
                ObjectId id = document.getObjectId("_id");
                Building building = parseDocumentToBuilding(document);
                buildings.put(id, building);
            }
        });

        return buildings;
    }

    private static Building parseDocumentToBuilding(Document document) {
        ObjectId id = document.getObjectId("_id");
        String name = document.getString("name");
        int basePopulation = document.getInteger("basePopulation");
        int baseTourists = document.getInteger("baseTourists");
        int baseIncome = document.getInteger("baseIncome");
        int turnPopulation = document.getInteger("turnPopulation");
        int turnTourists = document.getInteger("turnTourists");
        int turnIncome = document.getInteger("turnIncome");
        int price = document.getInteger("price");

        return new Building(id, name, basePopulation, baseTourists, baseIncome,
                turnPopulation, turnTourists, turnIncome, price);
    }
}
