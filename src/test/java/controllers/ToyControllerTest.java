package controllers;

import dtos.GoodToyDto;
import models.GoodToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.ToyRepository;
import views.ElfViewTest;

import static org.mockito.Mockito.*;

public class ToyControllerTest {

    private ToyRepository mockRepository;
    private ElfViewTest mockView;
    private ToyController toyController;

    @BeforeEach
    public void setup() {
        mockRepository = mock(ToyRepository.class); 
        mockView = mock(ElfViewTest.class); 
        toyController = new ToyController(mockRepository, mockView); 
    }

    @Test
    public void testPostGoodToy() {
        GoodToyDto goodToyDto = new GoodToyDto("LEGO Star Wars", "LEGO", 12, "Juguetes de Construcción");

        toyController.postGoodToy(goodToyDto);

        verify(mockRepository, times(1)).addGoodToy(any(GoodToy.class));

        verify(mockView, times(1)).addToyResponse();
    }
}