package newyearproject.views;

import newyearproject.controllers.ToyController;
import newyearproject.dtos.BadToyDto;
import newyearproject.dtos.GoodToyDto;
import static newyearproject.views.View.scanner;
import java.util.Scanner;

public class ElfView extends View {

    private static final ToyController controller = new ToyController();
    
    public static void index() {
        
        String menuElf = """
            -----------------------------------------
            Gestor de juguetes (Tipo de sesión: Elfo)
            1. Añadir juguete
            2. Ver todos los juguetes
            3. Eliminar juguete
            4. Cerrar sesión
            Seleccione una opción: """;

        System.out.print(menuElf + " ");

        int option = scanner.nextInt();

        if (option == 1) selectChild();
        if (option == 2) showAllTos();
        if (option == 3) deleteToy();
        if (option == 4) ClouseSession();
    }  
        
    public static void selectChild() {
            

        String menuChild =  """
            -----------------------------------------
            Para niño ...:
            1. Bueno
            2. Malo
            Seleccione una opción: """;
        System.out.print(menuChild + " ");

        int option = scanner.nextInt();

        if (option == 1) postGoodToy();
        if (option == 2) postBadToy();
    }
        
    private static void postBadToy() {
        System.out.println("-----------------------------------------");
        System.out.println("Ingrese el título:");
        String title = scanner.next();
        System.out.println("Ingrese la contenido: ");
        String content = scanner.next();

        controller.postBadToy(new BadToyDto(title, content));
    }
        
    public static void postGoodToy() {
        System.out.println("-----------------------------------------");
        System.out.println("Ingrese el título:");
        String title = scanner.next();
        System.out.println("Ingrese la marca:");
        String brand = scanner.next();
        System.out.println("Ingrese la edad recomendada:");
        int age = scanner.nextInt();
        System.out.println("Ingrese la categoria:");
        String category = scanner.next();

        controller.postGoodToy(new GoodToyDto(title, brand, age, category));
    }
    
    private static void showAllTos() {
        throw new UnsupportedOperationException("Unimplemented method 'showAllTos'");
    }

    private static void deleteToy() {
        throw new UnsupportedOperationException("Unimplemented method 'deleteToy'");
    }

    public static void ClouseSession() {
        HomeView.index();
    }

    public static void addToyResponse() {
        System.out.println("Toy added successfully");
        index();
    }
}