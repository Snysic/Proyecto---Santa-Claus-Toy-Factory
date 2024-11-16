package controllers;

import org.junit.jupiter.api.Test;
import views.HomeViewTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HomeControllerTest {

    @Test
    void testIndexCallsHomeViewIndex() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            new HomeController();

            String output = outputStream.toString();
            assertTrue(output.contains("Welcome to Home View"), "HomeView.index() was not called or output is incorrect");
        } finally {
            System.setOut(originalOut);
        }
    }
}