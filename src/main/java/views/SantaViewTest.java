package views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.ToyRepository;
import controllers.ToyController;

import static org.mockito.Mockito.*;

public class SantaViewTest {

    private ToyController mockController;

    @BeforeEach
    public void setup() {
        mockController = Mockito.mock(ToyController.class);
    }

    @Test
    public void testViewGoodToys() {
        SantaView santaView = new SantaView(mockController);

        when(scanner.nextInt()).thenReturn(1);

        santaView.viewGoodToys();

        verify(mockController, times(1)).viewGoodToys();
    }

    @Test
    public void testViewBadToys() {
        SantaView santaView = new SantaView(mockController);

        when(scanner.nextInt()).thenReturn(2);

        santaView.viewBadToys();

        verify(mockController, times(1)).viewBadToys();
    }

    @Test
    public void testSaveToysToCSV() {
        SantaView santaView = new SantaView(mockController);

        when(scanner.nextInt()).thenReturn(3);

        santaView.saveToysToCSV();

        verify(mockController, times(1)).saveToysToCSV();
    }
}
