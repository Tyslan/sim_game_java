package domain;

import domain.elements.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lorenz on 27/07/2016.
 */
public class Game {
    private List<City> cities;

    public Game(){
        cities = new ArrayList<>();
    }

    public void EndTurn(){
        cities.forEach(City::endTurn);
    }
}