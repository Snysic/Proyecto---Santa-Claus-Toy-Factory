package repository;

import models.GoodToy;
import models.BadToyTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToyRepositoryTest {

    private ToyRepository toyRepository;

    @BeforeEach
    public void setup() {
        toyRepository = new ToyRepository();
    }

    @Test
    public void testAddGoodToy() {
        GoodToy goodToy = new GoodToy("LEGO Star Wars", "LEGO", 12, "Juguetes de Construcción");
        toyRepository.addGoodToy(goodToy);

        assertEquals(1, toyRepository.getAllGoodToys().size());
        assertEquals(goodToy, toyRepository.getAllGoodToys().get(0));
    }

    @Test
    public void testAddBadToy() {
        BadToyTest badToy = new BadToyTest("Mystery Box", "Carbón");
        toyRepository.addBadToy(badToy);

        assertEquals(1, toyRepository.getAllBadToys().size());
        assertEquals(badToy, toyRepository.getAllBadToys().get(0));
    }
}