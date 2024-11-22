package newyearproject.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyTest {

    @Test
    void testConstructorWithoutId() {
        Toy toy = new Toy("Car", true);
        assertNull(toy.getId());
        assertEquals("Car", toy.getTitle());
        assertTrue(toy.isGoodToy());
    }

    @Test
    void testConstructorWithId() {
        Toy toy = new Toy("B1", "Car", true);
        assertEquals("B1", toy.getId());
        assertEquals("Car", toy.getTitle());
        assertTrue(toy.isGoodToy());
    }

    @Test
    void testSetId() {
        Toy toy = new Toy("Car", true);
        toy.setId(123);
        assertEquals("B123", toy.getId());
        
        toy.setGoodToy(false);
        toy.setId(456);
        assertEquals("M456", toy.getId());
    }

    @Test
    void testSetTitle() {
        Toy toy = new Toy("Car", true);
        toy.setTitle("Truck");
        assertEquals("Truck", toy.getTitle());
    }

    @Test
    void testSetGoodToy() {
        Toy toy = new Toy("Car", true);
        assertTrue(toy.isGoodToy());

        toy.setGoodToy(false);
        assertFalse(toy.isGoodToy());
    }

    @Test
    void testToString() {
        Toy toy = new Toy("B1", "Car", true);
        String expected = "Toy{id='B1', title='Car', isGoodToy=true}";
        assertEquals(expected, toy.toString());
    }
}
