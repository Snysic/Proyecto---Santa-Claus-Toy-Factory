package views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import newyearproject.views.HomeView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class HomeViewTest {

    private ByteArrayOutputStream outputStream;
    private static final String INPUT_ELFO = "1\n";  // Ввод для выбора "1. Elfo"
    private static final String INPUT_SANTA = "2\n";  // Ввод для выбора "2. Santa Claus"
    private static final String INPUT_EXIT = "3\n";  // Ввод для выбора "3. Salir"
    
    @BeforeEach
    public void setup() {
        // Создаём новый ByteArrayOutputStream для захвата вывода
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream)); // Подменяем System.out для захвата вывода
    }

    // Метод для симуляции ввода пользователя
    private void simulateInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // Подменяем System.in для имитации ввода
    }

    @Test
    public void testIndexElfoOption() {
        // Симулируем ввод для выбора "1. Elfo"
        simulateInput(INPUT_ELFO);

        // Вызываем статический метод HomeView.index()
        HomeView.index();

        // Проверяем, что вывод содержит ожидаемые строки
        String output = outputStream.toString();
        assertTrue(output.contains("Iniciar sesión de trabajo como:"));
        assertTrue(output.contains("1. Elfo"));
        assertTrue(output.contains("Seleccione una opción:"));
    }

    @Test
    public void testIndexSantaOption() {
        // Симулируем ввод для выбора "2. Santa Claus"
        simulateInput(INPUT_SANTA);

        // Вызываем статический метод HomeView.index()
        HomeView.index();

        // Проверяем, что вывод содержит ожидаемые строки
        String output = outputStream.toString();
        assertTrue(output.contains("Iniciar sesión de trabajo como:"));
        assertTrue(output.contains("2. Santa Claus"));
        assertTrue(output.contains("Seleccione una opción:"));
    }

    @Test
    public void testIndexQuitOption() {
        // Симулируем ввод для выбора "3. Salir"
        simulateInput(INPUT_EXIT);

        // Вызываем статический метод HomeView.index()
        HomeView.index();

        // Проверяем, что вывод содержит строки, указывающие на завершение работы
        String output = outputStream.toString();
        assertTrue(output.contains("Iniciar sesión de trabajo como:"));
        assertTrue(output.contains("3. Salir"));
    }
    
    @Test
    public void testIndexInvalidOption() {
        // Симулируем ввод для выбора неверной опции
        simulateInput("999\n");

        // Вызываем статический метод HomeView.index()
        HomeView.index();

        // Проверяем, что вывод содержит сообщение о неправильной опции
        String output = outputStream.toString();
        assertTrue(output.contains("Iniciar sesión de trabajo como:"));
        assertTrue(output.contains("Seleccione una opción:"));
    }
}