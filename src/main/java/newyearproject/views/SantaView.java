package newyearproject.views;

import newyearproject.controllers.ToyController;

public class SantaView {

    private final ToyController controller;

    public SantaView(ToyController controller) {
        this.controller = controller;
    }

    public void start() {
        while (true) {
            System.out.println("Welcome Santa");
            System.out.println("Toy Manager (Session: Santa)");
            System.out.println("1. Show good toys");
            System.out.println("2. Show bad toys");
            System.out.println("3. Save toys to CSV");
            System.out.println("4. Log out");
            System.out.print("Select an option: ");
            int option = View.scanner.nextInt();

            switch (option) {
                case 1:
                    controller.viewGoodToys();
                    break;
                case 2:
                    controller.viewBadToys();
                    break;
                case 3:
                    controller.saveToysToCSV();
                    break;
                case 4:
                    System.out.println("Exiting Santa's session...Happy New Year Santa!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}