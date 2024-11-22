package newyearproject.controllers;

import controllers.ToyController;
import dto.BadToyDto;
import dto.GoodToyDto;
import models.BadToy;
import models.GoodToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ToyRepository;
import singletons.ToyRepositorySingleton;
import views.ElfView;
 

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
            repository.setDB("good_toy");
            List<? extends Toy> goodToys = repository.getDB().getToys();
            writer.write("Good Toys:\n");
            for (Toy toy : goodToys) {
                writer.write(toy.toString() + "\n");
            }

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