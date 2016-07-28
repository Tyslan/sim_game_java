package domain.db;

import domain.elements.City;
import org.bson.Document;

/**
 * Created by Lorenz on 28/07/2016.
 */
public class CityUpdateThread implements Runnable {
    private City city;

    public CityUpdateThread(City city) {
        this.city = city;
    }

    @Override
    public void run() {
        Document toUpdate = new Document("name", city.getName());
        Document updateValues = parseCityToUpdateValues(city);
        DbConnection.db.getCollection("cities").updateOne(toUpdate, updateValues);
    }

    private static Document parseCityToUpdateValues(City city) {
        return
                new Document("$set", new Document("money", city.getMoney())
                        .append("population", city.getPopulation())
                        .append("tourists", city.getTourists())
                        .append("incomeNextTurn", city.getIncomeNextTurn()));
    }
}
