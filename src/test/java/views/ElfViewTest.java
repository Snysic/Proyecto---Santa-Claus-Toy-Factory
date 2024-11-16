package views;

import controllers.ToyController;
import dtos.GoodToyDto;
import models.GoodToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ToyRepository;
import views.ElfView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElfViewTest {

    private TestToyRepository repository;
    private TestElfView view;
    private ToyController controller;

    @BeforeEach
    void setUp() {
        repository = new TestToyRepository();
        view = new TestElfView();
        controller = new ToyController(repository, view);
        setPrivateControllerField(controller);
    }

    @Test
    void testPostGoodToy() {
        String input = "1\nCar\nMattel\n3\nVehicles\n";
        simulateUserInput(input);

        // Вызываем метод ElfView
        ElfView.index();

        // Проверяем, что игрушка была добавлена в репозиторий
        assertEquals(1, repository.getGoodToys().size());
        GoodToy toy = repository.getGoodToys().get(0);
        assertEquals("Car", toy.getTitle());
        assertEquals("Mattel", toy.getBrand());
        assertEquals(3, toy.getRecommendedAge());
        assertEquals("Vehicles", toy.getCategory());

        // Проверяем, что метод addToyResponse был вызван
        assertEquals(1, view.responseCallCount);
    }

    private void simulateUserInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    private void setPrivateControllerField(ToyController controllerInstance) {
        try {
            var field = ElfView.class.getDeclaredField("controller");
            field.setAccessible(true);
            field.set(null, controllerInstance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set private field 'controller'", e);
        }
    }

    // Поддельная реализация репозитория
    static class TestToyRepository implements ToyRepository {
        private final List<GoodToy> goodToys = new ArrayList<>();

        @Override
        public void addGoodToy(GoodToy toy) {
            goodToys.add(toy);
        }

        public List<GoodToy> getGoodToys() {
            return goodToys;
        }
    }

    // Поддельная реализация представления
    static class TestElfView {
        public int responseCallCount = 0;

        public void addToyResponse() {
            responseCallCount++;
        }
    }
}