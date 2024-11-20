package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import newyearproject.models.Toy;

import static org.junit.jupiter.api.Assertions.*;

class ToyTest {

    private Toy goodToy;
    private Toy badToy;

    @BeforeEach
    void setUp() {
        goodToy = new Toy("Good Toy", true);
        badToy = new Toy("Bad Toy", false);
    }

    @Test
    void testConstructorAndGetters() {

        assertEquals("Good Toy", goodToy.getTitle(), "Title of goodToy should be 'Good Toy'");
        assertTrue(goodToy.isGoodToy, "goodToy should be marked as a good toy");

        assertEquals("Bad Toy", badToy.getTitle(), "Title of badToy should be 'Bad Toy'");
        assertFalse(badToy.isGoodToy, "badToy should be marked as a bad toy");
    }

    @Test
    void testSetIdForGoodToy() {
     
        goodToy.setId(123);

 
        assertEquals("B123", goodToy.getId(), "ID of goodToy should start with 'B'");
    }

    @Test
    void testSetIdForBadToy() {
   
        badToy.setId(456);


        assertEquals("M456", badToy.getId(), "ID of badToy should start with 'M'");
    }

    @Test
    void testSetTitle() {
      
        goodToy.setTitle("Updated Good Toy");
        assertEquals("Updated Good Toy", goodToy.getTitle(), "Title should be updated to 'Updated Good Toy'");

        badToy.setTitle("Updated Bad Toy");
        assertEquals("Updated Bad Toy", badToy.getTitle(), "Title should be updated to 'Updated Bad Toy'");
    }
}