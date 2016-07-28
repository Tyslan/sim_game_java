package domain.controllers;

import domain.Game;
import domain.elements.City;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Created by Lorenz on 28/07/2016.
 */
public class GameController {
    private Game game;

    private ObservableList<City> cities;

    public GameController() {
        game = new Game();
        cities = FXCollections.observableArrayList(game.getCities());
    }

    public ObservableList<City> getCities() {
        return cities;
    }

    public boolean isCitiesEmpty() {
        return cities.isEmpty();
    }

    public void addCity(City city) {
        cities.add(city);
        game.addCity(city);
    }

    public void endTurn() {
        game.endTurn();
    }
}
