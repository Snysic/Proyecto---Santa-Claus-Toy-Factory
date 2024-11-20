package views;

import newyearproject.controllers.ToyController;
import newyearproject.db.ToysDB;
import newyearproject.views.SantaView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SantaViewTest {

    private ToyController controller;
    private ToysDB toysDB;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setup() {
        toysDB = new ToysDB();
        controller = new ToyController(toysDB);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    private void simulateInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void testViewGoodToysEmpty() {
        simulateInput("1\n");

        SantaView santaView = new SantaView(controller);
        santaView.start();

        String output = outputStream.toString();
        assertTrue(output.contains("No good toys available."));
    }

    @Test
    public void testViewBadToysEmpty() {
        simulateInput("2\n");

        SantaView santaView = new SantaView(controller);
        santaView.start();

        String output = outputStream.toString();
        assertTrue(output.contains("No bad toys available."));
    }

    @Test
    public void testSaveToysToCSV() {
        simulateInput("3\n");

        SantaView santaView = new SantaView(controller);
        santaView.start();

        String output = outputStream.toString();
        assertTrue(output.contains("Saving toys to CSV file..."));
        assertTrue(output.contains("No toys to save."));
    }

    @Test
    public void testInvalidOption() {
        simulateInput("999\n");

        SantaView santaView = new SantaView(controller);
        santaView.start();

        String output = outputStream.toString();
        assertTrue(output.contains("Opción inválida"));
    }
}