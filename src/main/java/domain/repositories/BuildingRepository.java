package domain.repositories;

import domain.elements.Building;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lorenz on 27/07/2016.
 */
public class BuildingRepository {
    private Map<ObjectId, Building> buildings;

    public BuildingRepository(){
        buildings = new HashMap<>();
    }

    public BuildingRepository(Map<ObjectId, Building> buildings){
        this.buildings = buildings;
    }

    public List<Building> getAllBuildings(){
        final List<Building> result = new ArrayList<>();
        buildings.values().forEach(
                result::add
        );
        return result;
    }

    public Building getBuildingById(ObjectId id){
        return buildings.get(id);
    }
}
