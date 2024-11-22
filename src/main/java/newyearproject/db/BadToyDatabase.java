package newyearproject.db;

import newyearproject.models.Toy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BadToyDatabase implements IDatabase<Toy> {

    private List<Toy> badToys;

    public BadToyDatabase() {
        initDB();
    }

    public List<Toy> getToys() {
        return badToys;
    }

    public void save(Toy toy) {
        badToys.add(toy);
        System.out.println("Bad Toy added: " + toy);
    }

    private void initDB() {
        this.badToys = new ArrayList<>(Arrays.asList(
                new Toy("M1", "Mystery Box 5x5", false)
        ));
    }
}