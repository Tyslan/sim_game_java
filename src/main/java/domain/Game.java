package domain;

import domain.elements.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lorenz on 27/07/2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class Game {
    private final List<City> cities;

    public Game() {
        cities = new ArrayList<>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public List<City> getCities() {
        return cities;
    }

    public void endTurn() {
        cities.forEach(City::endTurn);
    }
}