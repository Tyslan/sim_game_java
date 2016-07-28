package gui;

import domain.controllers.GameController;
import domain.elements.City;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by Lorenz on 28/07/2016.
 */
public class MainScreenFrame extends BorderPane {
    @FXML
    private Button btnAddCity;

    @FXML
    private Button btnEndTurn;

    @FXML
    private TabPane tabPane;

    private final GameController gameController;

    public MainScreenFrame(GameController gameController) {
        this.gameController = gameController;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainScreenFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        gameController.getCities().addListener(
                (ListChangeListener<City>) e -> btnEndTurn.setDisable(gameController.isCitiesEmpty())
        );
    }

    @FXML
    private void addCity() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Fonder une ville");
        dialog.setHeaderText("Fonder une ville");
        dialog.setContentText("Ajoutez un nom:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
            City city = new City(name);

            Tab tab = new Tab(name);
            CityTabFrame pane = new CityTabFrame(city);
            tab.setContent(pane);
            tabPane.getTabs().add(tab);

            gameController.addCity(city);
        });
    }

    @FXML
    private void endTurn() {
        gameController.endTurn();
    }
}
