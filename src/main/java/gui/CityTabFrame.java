package gui;

import domain.controllers.CityController;
import domain.elements.Building;
import domain.elements.City;
import domain.exceptions.NotEnoughMoneyException;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Lorenz on 28/07/2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class CityTabFrame extends GridPane implements Observer {
    @FXML
    private Button btnSendRight;

    @FXML
    private Label lblMoney;

    @FXML
    ListView<Building> listToBuild;
    @FXML
    ListView<Building> listBuild;

    private final CityController cityController;

    public CityTabFrame(City city) {
        cityController = new CityController(city);
        city.addObserver(this);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CityTabFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        listToBuild.setItems(cityController.getPossiblebuildings());
        listBuild.setItems(cityController.getBuildings());

        cityController.getPossiblebuildings().addListener(
                (ListChangeListener<Building>) e -> btnSendRight.setDisable(cityController.possibleBuildingsEmpty()));

        lblMoney.setText(cityController.getMoney() + "");
    }

    @FXML
    private void sendRight(ActionEvent event) {
        int index = listToBuild.getSelectionModel().getSelectedIndex();
        addBuilding(index);
    }

    private void addBuilding(int index) {
        if (index != -1) {
            Building building = listToBuild.getSelectionModel().getSelectedItem();
            try {
                cityController.addBuilding(building);
            } catch (NotEnoughMoneyException e) {
                showError("Erreur: Argent", e.getMessage());
            }
            listToBuild.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void mouseClickedToBuild(MouseEvent event) {
        if (event.getClickCount() == 2) {
            addBuilding(listToBuild.getSelectionModel().getSelectedIndex());
        }
    }

    private void showError(String type, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(type);
        alert.setContentText(message);

        alert.showAndWait();
    }

    @Override
    public void update(Observable o, Object arg) {
        City city = (City) o;
        lblMoney.setText(city.getMoney() + "");
    }
}
