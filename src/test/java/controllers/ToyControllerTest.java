package controllers;

import dtos.GoodToyDto;
import models.GoodToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.ToyRepository;
import views.ElfView;

import static org.mockito.Mockito.*;

public class ToyControllerTest {

    private ToyRepository mockRepository;
    private ToyController toyController;

    @BeforeEach
    public void setup() {
        mockRepository = Mockito.mock(ToyRepository.class);
        toyController = new ToyController(mockRepository);
    }

    @Test
    public void testPostGoodToy() {
        GoodToyDto goodToyDto = new GoodToyDto("LEGO Star Wars", "LEGO", 12, "Juguetes de Construcción");
        toyController.postGoodToy(goodToyDto);

        verify(mockRepository, times(1)).addGoodToy(any(GoodToy.class));

        verify(ElfView.class, times(1)).addToyResponse();
    }
}