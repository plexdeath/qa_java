package ru.yandex.praktikum.sprint6_tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import ru.yandex.praktikum.safonov_6_sprint.Feline;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests extends TestCase {
    private final String expected = "Кошачьи";

    @Spy
    private Feline feline;

    @Test
    public void getKittensOneTest() {
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(1);

        assertEquals("Количество котят не равно ожидаемому результату",
                1, actual);
    }

    @Test
    public void getKittensFiveTeenTest() {
        int actual = feline.getKittens(15);
        Mockito.verify(feline).getKittens(Mockito.anyInt());

        assertEquals("Количество котят не равно ожидаемому результату",
                15, actual);
    }

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();

        assertEquals("Ожидаемое семейство не равно ожидаемому результату",
                "Кошачьи", actual);
    }


}