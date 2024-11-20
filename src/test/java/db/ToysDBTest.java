package db;

import newyearproject.db.ToysDB;
import newyearproject.models.BadToy;
import newyearproject.models.GoodToy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToysDBTest {

    private ToysDB toysDB;

    @BeforeEach
    void setUp() {
      
        toysDB = new ToysDB();
    }

    @Test
    void testAddGoodToy() {
        
        GoodToy goodToy = new GoodToy("Toy Car", "Hot Wheels", 3, "Vehicles");

      
        toysDB.addGoodToy(goodToy);

        
        assertEquals(1, toysDB.getGoodToys().size(), "The good toys list should contain 1 toy");
        assertTrue(toysDB.getGoodToys().contains(goodToy), "The good toys list should contain the added toy");
    }

    @Test
    void testAddBadToy() {
       
        BadToy badToy = new BadToy("Broken Doll", "Sharp edges");

        
        toysDB.addBadToy(badToy);

       
        assertEquals(1, toysDB.getBadToys().size(), "The bad toys list should contain 1 toy");
        assertTrue(toysDB.getBadToys().contains(badToy), "The bad toys list should contain the added toy");
    }

    @Test
    void testGetGoodToys() {
       
        GoodToy goodToy1 = new GoodToy("Toy Car", "Hot Wheels", 3, "Vehicles");
        GoodToy goodToy2 = new GoodToy("Doll", "Barbie", 5, "Dolls");

       
        toysDB.addGoodToy(goodToy1);
        toysDB.addGoodToy(goodToy2);

        
        assertEquals(2, toysDB.getGoodToys().size(), "The good toys list should contain 2 toys");
        assertTrue(toysDB.getGoodToys().contains(goodToy1), "The good toys list should contain 'Toy Car'");
        assertTrue(toysDB.getGoodToys().contains(goodToy2), "The good toys list should contain 'Doll'");
    }

    @Test
    void testGetBadToys() {
       
        BadToy badToy1 = new BadToy("Broken Toy Car", "Missing wheels");
        BadToy badToy2 = new BadToy("Torn Teddy Bear", "Ripped fabric");

        
        toysDB.addBadToy(badToy1);
        toysDB.addBadToy(badToy2);

       
        assertEquals(2, toysDB.getBadToys().size(), "The bad toys list should contain 2 toys");
        assertTrue(toysDB.getBadToys().contains(badToy1), "The bad toys list should contain 'Broken Toy Car'");
        assertTrue(toysDB.getBadToys().contains(badToy2), "The bad toys list should contain 'Torn Teddy Bear'");
    }
}
