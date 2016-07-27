package elements;

import exceptions.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lorenz on 27/07/2016.
 */
public class City {
    private String name;
    private List<Building> buildings;
    private int population;
    private int tourists;
    private int money;

    public City(String name) {
        this.name = name;
        this.buildings = new ArrayList<>();
        this.population = 0;
        this.tourists = 0;
        this.money = 0;
    }

    public void addBuilding(Building building) throws NotEnoughMoneyException {
        if (money < building.getPrice()) {
            throw new NotEnoughMoneyException();
        }

        buildings.add(building);
        population += building.getBasePopulation();
        tourists += building.getBaseTourists();
        money += building.getBaseIncome();
    }

    public void endTurn() {
        buildings.forEach(
                building -> {
                    population += building.getTurnPopulation();
                    tourists += building.getTurnTourists();
                    money += building.getTurnIncome();
                }
        );
    }
}
