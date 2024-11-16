package db;

import models.BadToyTest;
import models.GoodToy;

import java.util.ArrayList;
import java.util.List;

public class ToysDB {
    private List<GoodToy> goodToys = new ArrayList<>();
    private List<BadToyTest> badToys = new ArrayList<>();

    public List<GoodToy> getGoodToys() {
        return goodToys;
    }

    public List<BadToyTest> getBadToys() {
        return badToys;
    }
}
