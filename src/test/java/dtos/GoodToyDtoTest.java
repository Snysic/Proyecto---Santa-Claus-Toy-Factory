package dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoodToyDtoTest {

    @Test
    void testGoodToyDto() {

        GoodToyDto dto = new GoodToyDto("Teddy Bear", "Hasbro", 5, "Plush");

        assertEquals("Teddy Bear", dto.title());
        assertEquals("Hasbro", dto.brand());
        assertEquals(5, dto.recommendedAge());
        assertEquals("Plush", dto.category());
    }
}