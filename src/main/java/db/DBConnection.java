package db;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by Lorenz on 27/07/2016.
 */
public class DBConnection {
    private static MongoClient mongoClient = new MongoClient();
    private static MongoDatabase db = mongoClient.getDatabase("sim-game");

    public static void getAllBuildings(){
        FindIterable<Document> iterable = db.getCollection("buildings").find();
        iterable.forEach(new Block<Document>() {
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }
}
