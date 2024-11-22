package newyearproject.controllers;

import newyearproject.repository.ToyRepository;
import newyearproject.singletons.ToyRepositorySingleton;
import newyearproject.models.GoodToy;
import newyearproject.models.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ToyController {

    private final ToyRepository repository;

    public ToyController() {
        this.repository = ToyRepositorySingleton.getInstance();
    }

    public void viewGoodToys() {
        repository.setDB("good_toy");
        List<? extends Toy> goodToys = repository.getDB().getToys();
        System.out.println("Good Toys:");
        for (Toy toy : goodToys) {
            System.out.println(toy);
        }
    }

    public void viewBadToys() {
        repository.setDB("bad_toy");
        List<? extends Toy> badToys = repository.getDB().getToys();
        System.out.println("Bad Toys:");
        for (Toy toy : badToys) {
            System.out.println(toy);
        }
    }

    public void saveToysToCSV() {
        try (FileWriter writer = new FileWriter("toys.csv")) {
            // Save good toys
            repository.setDB("good_toy");
            List<? extends Toy> goodToys = repository.getDB().getToys();
            writer.write("Good Toys:\n");
            for (Toy toy : goodToys) {
                writer.write(toy.toString() + "\n");
            }

            // Save bad toys
            repository.setDB("bad_toy");
            List<? extends Toy> badToys = repository.getDB().getToys();
            writer.write("Bad Toys:\n");
            for (Toy toy : badToys) {
                writer.write(toy.toString() + "\n");
            }

            System.out.println("Toys saved to toys.csv successfully.");
        } catch (IOException e) {
            System.err.println("Error saving toys to CSV: " + e.getMessage());
        }
    }
}