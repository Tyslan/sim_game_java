/**
 * Created by Lorenz on 27/07/2016.
 */

import db.DbConnection;
import elements.Building;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class sim_game_java extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<Building> buildings = DbConnection.getAllBuildings();
        buildings.forEach(
                System.out::println
        );
    }
}
