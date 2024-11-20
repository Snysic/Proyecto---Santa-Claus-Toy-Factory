package models;

import newyearproject.dtos.GoodToyDto;
import newyearproject.models.GoodToy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GoodToyTest {

    @Test
    public void testGoodToyInitialization() {
        // Создание объекта GoodToy
        GoodToy goodToy = new GoodToy("Car", "BrandX", 5, "Vehicle");

        // Проверка, что поля инициализируются правильно
        assertEquals("Car", goodToy.getTitle());
        assertEquals("BrandX", goodToy.getBrand());
        assertEquals(5, goodToy.getTargetAge());
        assertEquals("Vehicle", goodToy.getCategory());
    }

    @Test
    public void testToDto() {
        // Создание объекта GoodToy
        GoodToy goodToy = new GoodToy("Car", "BrandX", 5, "Vehicle");

        // Преобразование объекта GoodToy в GoodToyDto
        GoodToyDto dto = goodToy.toDto();

        // Проверка, что данные в GoodToyDto совпадают с исходными значениями
        assertEquals("Car", dto.title());
        assertEquals("BrandX", dto.brand());
        assertEquals(5, dto.recommendedAge());
        assertEquals("Vehicle", dto.category());
    }

    @Test
    public void testToString() {
        // Создание объекта GoodToy
        GoodToy goodToy = new GoodToy("Car", "BrandX", 5, "Vehicle");

        // Проверка, что метод toString() возвращает правильное строковое представление
        String expectedString = "Título: Car, Marca: BrandX, Edad Recomendada: 5, Categoría: Vehicle";
        assertEquals(expectedString, goodToy.toString());
    }
}
