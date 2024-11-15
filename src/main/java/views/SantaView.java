package views;

import controllers.ToyController;

public class SantaView {

    private final ToyController controller;

    public SantaView(ToyController controller) {
        this.controller = controller;
    }

    public void viewGoodToys() {
        System.out.println("Vista de juguetes para niños buenos...");
        controller.viewGoodToys();
    }

    public void viewBadToys() {
        System.out.println("Vista de juguetes para niños malos...");
        controller.viewBadToys();
    }

    public void saveToysToCSV() {
        System.out.println("Guardando juguetes en archivo CSV...");
        controller.saveToysToCSV();
    }

    public void closeSession() {
        System.out.println("Sesión cerrada.");
    }
}
