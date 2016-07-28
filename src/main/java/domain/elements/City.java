package domain.elements;

import domain.exceptions.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Lorenz on 27/07/2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class City extends Observable {
    private static final int POPULATION_INCOME = 100;
    private static final int TOURIST_INCOME = 50;


    private final String name;
    private final List<Building> buildings;
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

    public String getName(){
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getTourists() {
        return tourists;
    }

    public int getMoney() {
        return money;
    }

    public int getIncomeNextTurn(){
        int result = 0;

        for(Building building: buildings){
            int popIncome = population * POPULATION_INCOME;
            int touristIncome = tourists * TOURIST_INCOME;
            result += building.getTurnIncome() + popIncome + touristIncome;
        }

        return result;
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
