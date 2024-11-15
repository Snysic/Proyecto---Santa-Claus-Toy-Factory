package views;

import controllers.ToyController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class SantaViewTest {

    private ToyController mockController;
    private SantaView santaView;

    @BeforeEach
    public void setup() {

        mockController = Mockito.mock(ToyController.class);
        santaView = new SantaView(mockController);
    }

    @Test
    public void testViewGoodToys() {
        System.setIn(new java.io.ByteArrayInputStream("1".getBytes())); 

        santaView.viewGoodToys();

        verify(mockController, times(1)).viewGoodToys();
    }

    @Test
    public void testViewBadToys() {
        System.setIn(new java.io.ByteArrayInputStream("2".getBytes())); 

        santaView.viewBadToys();

        verify(mockController, times(1)).viewBadToys();
    }

    @Test
    public void testSaveToysToCSV() {
        System.setIn(new java.io.ByteArrayInputStream("3".getBytes()));

        santaView.saveToysToCSV();

        verify(mockController, times(1)).saveToysToCSV();
    }
}
