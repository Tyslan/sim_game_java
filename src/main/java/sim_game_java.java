/**
 * Created by Lorenz on 27/07/2016.
 */

import domain.db.DbConnection;
import domain.elements.Building;
import javafx.application.Application;
import javafx.stage.Stage;
import org.bson.types.ObjectId;

import java.util.Map;

public class sim_game_java extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Getting all buildings");
        Map<ObjectId, Building> buildings = DbConnection.getAllBuildings();
        buildings.values().forEach(
                System.out::println
        );
    }
}
