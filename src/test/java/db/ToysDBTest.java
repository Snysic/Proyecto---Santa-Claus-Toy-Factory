package db;

import models.GoodToy;
import models.BadToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToysDBTest {

    private ToysDB toysDB;

    @BeforeEach
    public void setup() {
        toysDB = new ToysDB();
    }

    @Test
    public void testAddGoodToy() {
        GoodToy goodToy = new GoodToy("LEGO Star Wars", "LEGO", 12, "Juguetes de Construcción");
        toysDB.getGoodToys().add(goodToy);

        assertEquals(1, toysDB.getGoodToys().size());
        assertEquals(goodToy, toysDB.getGoodToys().get(0));
    }

    @Test
    public void testAddBadToy() {
        BadToy badToy = new BadToy("Mystery Box", "Carbón");
        toysDB.getBadToys().add(badToy);

        assertEquals(1, toysDB.getBadToys().size());
        assertEquals(badToy, toysDB.getBadToys().get(0));
    }
}
