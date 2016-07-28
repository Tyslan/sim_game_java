package domain.repositories;

import domain.db.DbConnection;
import domain.elements.Building;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lorenz on 27/07/2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class BuildingRepository {
    private final Map<ObjectId, Building> buildings;

    public BuildingRepository() {
        buildings = DbConnection.getAllBuildings();
    }

    public BuildingRepository(Map<ObjectId, Building> buildings) {
        this.buildings = buildings;
    }

    public List<Building> getAllBuildings() {
        final List<Building> result = new ArrayList<>();
        buildings.values().forEach(
                result::add
        );
        return result;
    }

    public Building getBuildingById(ObjectId id) {
        return buildings.get(id);
    }
}
