package ru.yandex.praktikum.sprint6_tests;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.yandex.praktikum.safonov_6_sprint.Feline;
import ru.yandex.praktikum.safonov_6_sprint.Lion;

import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTests extends TestCase {

    private Lion lion;
    @Mock
    private Feline feline;

    @Test
    public void getFoodTestMale() throws Exception {
        lion = new Lion("Самец", feline);

        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void getFoodTestFEMale() throws Exception {
        lion = new Lion("Самка", feline);

        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void getKitenTestsMale() throws Exception {
        lion = new Lion("Самец", feline);

        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getKitenTestsFEMale() throws Exception {
        lion = new Lion("Самка", feline);

        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }


    @Test
    public void isManeTest() throws Exception {
        lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(true, actual);
    }

    @Test
    public void ExceptionTest() {
        Throwable throwable = assertThrows(Exception.class, () -> {
            lion = new Lion("unsupported sex", feline);
        });
        assertEquals(Exception.class, throwable.getClass());
        assertEquals("Используйте допустимые значения пола животного - самей или самка", throwable.getMessage());
    }


}