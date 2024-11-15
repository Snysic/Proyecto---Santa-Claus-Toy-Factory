package views;

import controllers.ToyController;
import dtos.GoodToyDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class ElfViewTest {

    private final ToyController mockController = Mockito.mock(ToyController.class);

    @Test
    public void testPostGoodToy() {
        ElfView elfView = new ElfView(mockController);
        GoodToyDto goodToyDto = new GoodToyDto("LEGO Star Wars", "LEGO", 12, "Juguetes de Construcción");

        when(scanner.next()).thenReturn("LEGO Star Wars", "LEGO", "12", "Juguetes de Construcción");

        elfView.postGoodToy();

        verify(mockController, times(1)).postGoodToy(goodToyDto);
    }
}
