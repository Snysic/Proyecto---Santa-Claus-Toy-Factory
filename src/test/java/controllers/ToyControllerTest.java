package controllers;

import newyearproject.controllers.ToyController;
import newyearproject.db.ToysDB;
import newyearproject.models.BadToy;
import newyearproject.models.GoodToy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToyControllerTest {

    private ToysDB toysDB;

    @BeforeEach
    public void setup() {
        toysDB = new ToysDB();

        
        toysDB.getGoodToys().add(new GoodToy("Teddy Bear", "Hasbro", 3, "Plush"));
        toysDB.getBadToys().add(new BadToy("Broken Car", "Missing wheels"));
    }

    
    private String captureOutput(Runnable action) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; 
        System.setOut(new PrintStream(outputStream)); 

        try {
            action.run(); 
        } finally {
            System.setOut(originalOut); 
        }

        return outputStream.toString().trim(); 
    }

    @Test
    public void testViewGoodToys() {
        ToyController toyController = new ToyController(toysDB);

        String output = captureOutput(toyController::viewGoodToys);

        assertTrue(output.contains("Displaying Good Toys"));
        assertTrue(output.contains("Teddy Bear")); 
    }

    @Test
    public void testViewBadToys() {
        ToyController toyController = new ToyController(toysDB);

        String output = captureOutput(toyController::viewBadToys);

        assertTrue(output.contains("Displaying Bad Toys"));
        assertTrue(output.contains("Broken Car")); 
    }

    @Test
    public void testSaveToysToCSV() {
        ToyController toyController = new ToyController(toysDB);

        String output = captureOutput(toyController::saveToysToCSV);

        assertTrue(output.contains("Saving toys to CSV file."));
        assertTrue(output.contains("Toys saved successfully to CSV."));
    }

    @Test
    public void testViewGoodToysWithEmptyDB() {
        toysDB.getGoodToys().clear();
        ToyController toyController = new ToyController(toysDB);

        String output = captureOutput(toyController::viewGoodToys);

        assertTrue(output.contains("No good toys available."));
    }

    @Test
    public void testViewBadToysWithEmptyDB() {
        toysDB.getBadToys().clear(); 
        ToyController toyController = new ToyController(toysDB);

        String output = captureOutput(toyController::viewBadToys);

        assertTrue(output.contains("No bad toys available."));
    }

    @Test
    public void testSaveToysToCSVWithEmptyDB() {
        toysDB.getGoodToys().clear(); 
        toysDB.getBadToys().clear(); 
        ToyController toyController = new ToyController(toysDB);

        String output = captureOutput(toyController::saveToysToCSV);

        assertTrue(output.contains("No toys to save."));
    }
}
