package domain.controllers;

import domain.Game;
import domain.db.DbConnection;
import domain.elements.City;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Created by Lorenz on 28/07/2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class GameController {
    private final Game game;

    private final ObservableList<City> cities;

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

        DbConnection.persistCity(city);
    }

    public void endTurn() {
        game.endTurn();
        cities.forEach(city -> DbConnection.updateCity(city));
    }
}
