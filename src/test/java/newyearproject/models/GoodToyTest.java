package newyearproject.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GoodToyTest {
    @Test
    void testToString() {
GoodToy goodToy = new GoodToy("Car", true, "BrandX", 5, "Vehicle");

        String expectedString = "GoodToy{title='Car', brand='BrandX', targetAge=5, category='Vehicle'}";
        assertEquals(expectedString, goodToy.toString());

    }
}
