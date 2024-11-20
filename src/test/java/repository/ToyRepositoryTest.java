package repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.BadToyTest;
import newyearproject.models.GoodToy;
import newyearproject.repository.ToyRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ToyRepositoryTest {

    private ToyRepository toyRepository;

    @BeforeEach
    public void setup() {
        toyRepository = new ToyRepository();
    }

    @Test
    public void testAddGoodToy() {
        // Создаем хорошую игрушку
        GoodToy goodToy = new GoodToy("Car", "HotWheels", 5, "Vehicles");

        // Добавляем игрушку в репозиторий
        toyRepository.addGoodToy(goodToy);

        // Проверяем, что размер списка игрушек увеличился на 1
        assertEquals(1, toyRepository.getAllGoodToys().size());

        // Проверяем, что ID был правильно назначен
        assertEquals(1, goodToy.getId());
    }

    @Test
    public void testAddBadToy() {
        // Создаем плохую игрушку
        BadToyTest badToy = new BadToyTest("Broken Toy", "Reason for bad quality");

        // Добавляем игрушку в репозиторий
        toyRepository.addBadToy(badToy);

        // Проверяем, что размер списка плохих игрушек увеличился на 1
        assertEquals(1, toyRepository.getAllBadToys().size());

        // Проверяем, что ID был правильно назначен
        assertEquals(1, badToy.getId());
    }

    @Test
    public void testGetAllGoodToys() {
        // Добавляем несколько хороших игрушек
        GoodToy goodToy1 = new GoodToy("Car", "HotWheels", 5, "Vehicles");
        GoodToy goodToy2 = new GoodToy("Doll", "Barbie", 3, "Figures");

        toyRepository.addGoodToy(goodToy1);
        toyRepository.addGoodToy(goodToy2);

        // Проверяем, что в репозитории есть 2 хороших игрушки
        assertEquals(2, toyRepository.getAllGoodToys().size());
    }

    @Test
    public void testGetAllBadToys() {
        // Добавляем несколько плохих игрушек
        BadToyTest badToy1 = new BadToyTest("Broken Toy", "Reason1");
        BadToyTest badToy2 = new BadToyTest("Old Toy", "Reason2");

        toyRepository.addBadToy(badToy1);
        toyRepository.addBadToy(badToy2);

        // Проверяем, что в репозитории есть 2 плохих игрушки
        assertEquals(2, toyRepository.getAllBadToys().size());
    }
}