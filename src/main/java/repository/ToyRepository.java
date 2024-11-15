package repository;

import db.ToysDB;
import models.BadToy;
import models.GoodToy;

import java.util.List;

public class ToyRepository {
    private final ToysDB database = new ToysDB();

    public void addGoodToy(GoodToy goodToy) {
        goodToy.setId(database.getGoodToys().size() + 1);
        database.getGoodToys().add(goodToy);
    }

    public void addBadToy(BadToy badToy) {
        badToy.setId(database.getBadToys().size() + 1);
        database.getBadToys().add(badToy);
    }

    public List<GoodToy> getAllGoodToys() {
        return database.getGoodToys();
    }

    public List<BadToy> getAllBadToys() {
        return database.getBadToys();
    }
}
