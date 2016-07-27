/**
 * Created by Lorenz on 27/07/2016.
 */

import db.DBConnection;
import javafx.application.Application;
import javafx.stage.Stage;

public class sim_game_java extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        DBConnection.getAllBuildings();
    }
}
