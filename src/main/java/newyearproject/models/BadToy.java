package newyearproject.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import newyearproject.models.BadToy;

import newyearproject.db.IDatabase;

public class BadToy implements IDatabase<BadToy> {

    private List<BadToy> badToys;

    public BadToy() {
        initDB();
    }

    public List<BadToy> getToys() {
        return badToys;
    }

    public void save(BadToy toy) {
        badToys.add(toy);
        System.out.println("bad toy added");
    }

    private void initDB() {
        this.badToys = new ArrayList<>(Arrays.asList(
                new BadToy("M1", "Mystery Box 5x5", true, "carbón")));
    }

}

