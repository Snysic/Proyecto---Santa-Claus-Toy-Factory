package newyearproject.views;

public class HomeView extends View {

    public static void index() {
        // menu de inicio
        System.out.println("Iniciar sesión de trabajo como:");
        System.out.println("1. Elfo");
        System.out.println("2. Santa Claus");
        System.out.println("3. Salir");
        System.out.println("Seleccione una opción:");

        int option = scanner.nextInt();

        if (option == 1) ElfView.index();
        if (option == 3) quit();
    }

    public static void quit() {
        scanner.close();
    }

}