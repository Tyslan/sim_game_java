package domain.controllers;

import domain.elements.Building;
import domain.elements.City;
import domain.exceptions.NotEnoughMoneyException;
import domain.repositories.BuildingRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.bson.types.ObjectId;

/**
 * Created by Lorenz on 28/07/2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class CityController {
    private static final BuildingRepository buildingRepository = new BuildingRepository();

    private final City city;

    private final ObservableList<Building> possiblebuildings;
    private final ObservableList<Building> buildings;

    public CityController(City city) {
        this.city = city;
        buildings = FXCollections.observableArrayList(city.getBuildings());
        possiblebuildings = FXCollections.observableArrayList(buildingRepository.getAllBuildings());

        // add city hall
        ObjectId id = new ObjectId("5799ced921f62711009db043");
        Building building = buildingRepository.getBuildingById(id);

        try {
            addBuilding(building);
        } catch (NotEnoughMoneyException e) {
            //this will never happen because city hall is free
            e.printStackTrace();
        }
    }

    public ObservableList<Building> getPossiblebuildings() {
        return possiblebuildings;
    }

    public ObservableList<Building> getBuildings() {
        return buildings;
    }

    public boolean possibleBuildingsEmpty() {
        return possiblebuildings.isEmpty();
    }

    public void addBuilding(Building building) throws NotEnoughMoneyException {
        city.addBuilding(building);
        buildings.add(building);
        possiblebuildings.remove(building);
    }

    public int getMoney() {
        return city.getMoney();
    }
}
