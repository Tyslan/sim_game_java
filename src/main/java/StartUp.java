/**
 * Created by Lorenz on 27/07/2016.
 */

import domain.controllers.GameController;
import gui.MainScreenFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartUp extends Application {

    public static void main(String[] args) {
        launch(StartUp.class, args);
    }

    @Override
    public void start(Stage stage) {

        GameController gameController = new GameController();
        Scene scene = new Scene(new MainScreenFrame(gameController));
        stage.setScene(scene);

        stage.setTitle("Le meilleur maire");

        // The stage will not get smaller than its preferred (initial) size.
        stage.setOnShown((WindowEvent t) -> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });
        stage.show();
    }
}
