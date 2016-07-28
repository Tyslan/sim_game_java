package domain.elements;

import org.bson.types.ObjectId;

/**
 * Created by Lorenz on 27/07/2016.
 */
public class Building {
    private ObjectId id;
    private String name;
    private int basePopulation;
    private int baseTourists;
    private int baseIncome;
    private int turnPopulation;
    private int turnTourists;
    private int turnIncome;
    private int price;

    public Building(ObjectId id, String name, int basePopulation, int baseTourists, int baseIncome, int turnPopulation,
                    int turnTourists, int turnIncome, int price) {
        this.id = id;
        this.name = name;
        this.basePopulation = basePopulation;
        this.baseTourists = baseTourists;
        this.baseIncome = baseIncome;
        this.turnPopulation = turnPopulation;
        this.turnTourists = turnTourists;
        this.turnIncome = turnIncome;
        this.price = price;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBasePopulation() {
        return basePopulation;
    }

    public int getBaseTourists() {
        return baseTourists;
    }

    public int getBaseIncome() {
        return baseIncome;
    }

    public int getTurnPopulation() {
        return turnPopulation;
    }

    public int getTurnTourists() {
        return turnTourists;
    }

    public int getTurnIncome() {
        return turnIncome;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }
}
