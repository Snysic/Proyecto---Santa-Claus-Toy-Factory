package views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import newyearproject.views.ElfView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElfViewTest {

    private ElfView elfView;
    private ByteArrayOutputStream outputStream;

    @Mock
    private ToyController toyController;

    @BeforeEach
    public void setup() {
        // Инициализация Mockito аннотаций
        MockitoAnnotations.openMocks(this);

        // Создание нового ByteArrayOutputStream для захвата вывода
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));  // Подменяем System.out

        // Инициализация ElfView с mock-объектом ToyController
        elfView = new ElfView(toyController);
    }

    // Метод для симуляции ввода пользователя
    private void simulateInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Подменяем System.in для имитации ввода
    }

    @Test
    public void testAddGoodToy() {
        // Симулируем ввод данных, которые будут использоваться в методе postGoodToy
        simulateInput("1\nCar\nHotWheels\n5\nVehicles\n5\n");

        // Вызываем метод index(), который будет обрабатывать введенную команду
        elfView.index();

        // Получаем весь вывод, который был напечатан на экране
        String output = outputStream.toString();

        // Проверяем, что вывод содержит текст, который мы ожидали
        assertTrue(output.contains("Ingrese el título:"));
        assertTrue(output.contains("Ingrese la marca:"));
        assertTrue(output.contains("Ingrese la edad recomendada:"));
        assertTrue(output.contains("Ingrese la categoria:"));
        assertTrue(output.contains("Juguete añadido con éxito"));

        // Проверяем, что метод controller.postGoodToy был вызван с нужным объектом
        verify(toyController).postGoodToy(any(GoodToyDto.class));
    }

    @Test
    public void testCloseSession() {
        // Симулируем выбор опции "Cerrar sesión" (5)
        simulateInput("5\n");

        // Вызываем метод index(), который будет обрабатывать введенную команду
        elfView.index();

        // Проверяем, что в выводе есть сообщение о закрытии сессии
        String output = outputStream.toString();
        assertTrue(output.contains("Sesión cerrada."));
    }

    @Test
    public void testInvalidOption() {
        // Симулируем ввод некорректной опции
        simulateInput("99\n");

        // Вызываем метод index(), который будет обрабатывать введенную команду
        elfView.index();

        // Проверяем, что в выводе содержится сообщение об ошибке
        String output = outputStream.toString();
        assertTrue(output.contains("Opción inválida"));
    }
}