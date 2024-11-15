package controllers;

import dtos.GoodToyDto;
import models.GoodToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.ToyRepository;

import static org.mockito.Mockito.*;

public class ToyControllerTest {

    private ToyRepository toyRepository;
    private ToyController toyController;

    @BeforeEach
    public void setup() {
        toyRepository = mock(ToyRepository.class);
        toyController = new ToyController(toyRepository);
    }

    @Test
    public void testPostGoodToy() {
        GoodToyDto goodToyDto = new GoodToyDto("LEGO Star Wars", "LEGO", 12, "Juguetes de Construcción");
        GoodToy goodToy = new GoodToy(goodToyDto.title(), goodToyDto.brand(), goodToyDto.recommendedAge(), goodToyDto.category(), true);

        toyController.postGoodToy(goodToyDto);

        verify(toyRepository, times(1)).addGoodToy(goodToy);
    }

    @Test
    public void testPostBadToy() {
        BadToy badToy = new BadToy("Mystery Box", "Carbón");

        toyController.postBadToy("Mystery Box", "Carbón");

        verify(toyRepository, times(1)).addBadToy(badToy);
    }

    @Test
    public void testRemoveToy() {
        GoodToy goodToy = new GoodToy("LEGO Star Wars", "LEGO", 12, "Juguetes de Construcción");
        toyController.removeToy(goodToy);

        verify(toyRepository, times(1)).removeToy(goodToy);
    }
}
