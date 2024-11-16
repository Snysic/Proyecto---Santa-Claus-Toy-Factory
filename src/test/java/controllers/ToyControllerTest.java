package controllers;

import dtos.GoodToyDto;
import models.GoodToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import repository.ToyRepository;
import views.ElfViewTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ToyControllerTest {

    private ToyRepository repositoryMock;
    private ElfViewTest viewMock;
    private ToyController controller;

    @BeforeEach
    void setUp() {
        repositoryMock = mock(ToyRepository.class);
        viewMock = mock(ElfViewTest.class);
        controller = new ToyController(repositoryMock, viewMock);
    }

    @Test
    void testPostGoodToy() {
        GoodToyDto dto = new GoodToyDto("Teddy Bear", "Hasbro", 5, "Plush");

        controller.postGoodToy(dto);

        ArgumentCaptor<GoodToy> toyCaptor = ArgumentCaptor.forClass(GoodToy.class);
        verify(repositoryMock, times(1)).addGoodToy(toyCaptor.capture());

        GoodToy capturedToy = toyCaptor.getValue();
        assertEquals("Teddy Bear", capturedToy.getTitle());
        assertEquals("Hasbro", capturedToy.getBrand());
        assertEquals(5, capturedToy.getRecommendedAge());
        assertEquals("Plush", capturedToy.getCategory());

        verify(viewMock, times(1)).addToyResponse();
    }
}