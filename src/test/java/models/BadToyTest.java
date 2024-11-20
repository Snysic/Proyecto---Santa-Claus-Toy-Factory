package models;

import org.junit.jupiter.api.Test;

import newyearproject.models.BadToy;

import static org.junit.jupiter.api.Assertions.*;

class BadToyTest {

    @Test
    void testConstructorAndGetters() {
        String title = "Broken Toy";
        String content = "Sharp edges";

        // Act
        BadToy badToy = new BadToy(title, content);

        assertEquals(title, badToy.getTitle(), "Title should match the constructor argument");
        assertEquals(content, badToy.getContent(), "Content should match the constructor argument");
        
    }

    @Test
    void testToString() {
        String title = "Defective Toy";
        String content = "Toxic material";
        BadToy badToy = new BadToy(title, content);

        String result = badToy.toString();

        String expected = String.format("Título: %s, Contenido: %s", title, content);
        assertEquals(expected, result, "toString() should return the expected formatted string");
    }
}
