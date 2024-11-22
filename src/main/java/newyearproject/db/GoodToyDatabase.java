package newyearproject.db;

import newyearproject.models.GoodToy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodToyDatabase implements IDatabase<GoodToy> {

    private List<GoodToy> goodToys;

    public GoodToyDatabase() {
        initDB();
    }

    public List<GoodToy> getToys() {
        return goodToys;
    }

    public void save(GoodToy toy) {
        goodToys.add(toy);
        System.out.println("Good Toy added: " + toy);
    }

    private void initDB() {
        this.goodToys = new ArrayList<>(
            Arrays.asList(
                new GoodToy("Batman", true, "LEGO", 12, "Construction")
            )
        );
    }
    
}
