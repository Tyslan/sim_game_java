package domain.elements;

import domain.exceptions.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Lorenz on 27/07/2016.
 */
public class City extends Observable {
    private static final int POPULATION_INCOME = 700;
    private static final int TOURIST_INCOME = 400;


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
        this.money = 500000;
    }

    public int getMoney() {
        return money;
    }

    public void addBuilding(Building building) throws NotEnoughMoneyException {
        if (money < building.getPrice()) {
            throw new NotEnoughMoneyException();
        }

        buildings.add(building);

        money -= building.getPrice();
        population += building.getBasePopulation();
        tourists += building.getBaseTourists();
        money += building.getBaseIncome();

        setChanged();
        notifyObservers();
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void endTurn() {
        buildings.forEach(
                building -> {
                    int popIncome = population * POPULATION_INCOME;
                    int touristIncome = tourists * TOURIST_INCOME;
                    population += building.getTurnPopulation();
                    tourists += building.getTurnTourists();
                    money += building.getTurnIncome() + popIncome + touristIncome;
                }
        );

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return name;
    }
}
