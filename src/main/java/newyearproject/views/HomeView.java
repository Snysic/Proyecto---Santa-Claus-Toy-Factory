package newyearproject.views;

import newyearproject.controllers.ToyController;

public class HomeView extends View {

    public static void index() {
        System.out.println("WELCOME");
        System.out.println("Login under:");
        System.out.println("1. Elf");
        System.out.println("2. Santa Claus");
        System.out.println("3. Log out");
        System.out.print("Select an option: ");

        int option = scanner.nextInt();

        if (option == 1) {
            ElfView.index(); 
        } else if (option == 2) {
            new SantaView(new ToyController()).start(); 
        } else if (option == 3) {
            quit(); 
        } else {
            System.out.println("Invalid option!");
        }
    }

    public static void quit() {
        System.out.println("Exit the program. Goodbye! Happy New Year!");
        scanner.close();
    }
}
    