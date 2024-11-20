package views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import newyearproject.views.View;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ViewTest {

    private ByteArrayOutputStream outputStream;
    private static final String VALID_INPUT = "42";
    private static final String INVALID_INPUT = "invalid";

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
    public void testGetIntInputValid() {
        // Симулируем ввод целого числа
        simulateInput(VALID_INPUT + "\n");

        // Используем метод getIntInput() для получения целого числа
        int input = View.getIntInput();

        // Проверяем, что метод правильно захватил введённое число
        assertEquals(42, input);
    }

    @Test
    public void testCloseScanner() {
        // Проверяем, что Scanner можно закрыть без ошибок
        View.closeScanner();
        
        // Проверяем, что метод не вызвал вывод ошибок при закрытии
        assertTrue(outputStream.toString().isEmpty());  // Тестируем, что нет вывода после закрытия
    }
}
