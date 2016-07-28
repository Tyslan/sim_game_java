package domain.db;

import domain.elements.City;
import org.bson.Document;

/**
 * Created by Lorenz on 28/07/2016.
 */
public class CityPersistThread implements Runnable{
    private City city;

    public CityPersistThread(City city){
        this.city = city;
    }

    @Override
    public void run() {
        Document document = parseCityToDocument(city);
        DbConnection.db.getCollection("cities").insertOne(document);
    }

    private static Document parseCityToDocument(City city) {
        return
                new Document("name", city.getName())
                        .append("money", city.getMoney())
                        .append("population", city.getPopulation())
                        .append("tourists", city.getTourists())
                        .append("incomeNextTurn", city.getIncomeNextTurn());
    }
}
