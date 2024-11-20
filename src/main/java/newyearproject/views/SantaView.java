package newyearproject.views;

import java.util.Scanner;

import newyearproject.controllers.ToyController;

public class SantaView {

    private final ToyController controller;
    private final Scanner scanner;

    public SantaView(ToyController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("-----------------------------------------");
            System.out.println("Gestor de juguetes (Tip de sesión: Santa)");
            System.out.println("1. Ver juguetes buenos");
            System.out.println("2. Ver juguetes malos");
            System.out.println("3. Guardar juguetes en CSV");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción:");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    viewGoodToys();
                    break;
                case 2:
                    viewBadToys();
                    break;
                case 3:
                    saveToysToCSV();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    public void viewGoodToys() {
        System.out.println("Viewing Good Toys");
        controller.viewGoodToys();
    }

    public void viewBadToys() {
        System.out.println("Viewing Bad Toys");
        controller.viewBadToys();
    }

    public void saveToysToCSV() {
        System.out.println("Saving Toys to CSV");
        controller.saveToysToCSV();
    }
}
