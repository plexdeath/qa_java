package ru.yandex.praktikum.sprint6_tests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import ru.yandex.praktikum.safonov_6_sprint.Cat;
import ru.yandex.praktikum.safonov_6_sprint.Feline;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class) // Подключаем Mockito к тестовому классу, чтобы использовать мок именно в нём.
public class CatTests {
    @Mock
    private Feline feline;
    private Cat cat;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());// Проверяем, что метод возвращает ожидаемое значение
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("китикэт", "сливки"); //Мочим результат
        when(cat.getFood()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood(); // Вызываем тестируемый метод
        assertEquals(expectedFood, actualFood); // Проверяем
    }
}