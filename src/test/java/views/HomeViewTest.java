package views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class HomeViewTest {

    @BeforeEach
    public void setup() {
        HomeView homeView = mock(HomeView.class);
    }

    @Test
    public void testIndex() {
        HomeView homeView = mock(HomeView.class);

        homeView.index();

        verify(homeView, times(1)).index();
    }

    @Test
    public void testQuit() {
        HomeView.quit();
        verify(HomeView.class, times(1)).quit();
    }
}

