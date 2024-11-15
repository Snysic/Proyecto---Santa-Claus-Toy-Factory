package db;

import models.BadToy;
import models.GoodToy;

import java.util.ArrayList;
import java.util.List;

public class ToysDB {
    private List<GoodToy> goodToys = new ArrayList<>();
    private List<BadToy> badToys = new ArrayList<>();

    public List<GoodToy> getGoodToys() {
        return goodToys;
    }

    public List<BadToy> getBadToys() {
        return badToys;
    }
}
