package ru.yandex.praktikum.sprint6_tests;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.safonov_6_sprint.Animal;
import java.util.List;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class AnimalTests  extends TestCase {
    private Animal animal;
    private static final String ANIMAL_PREDATOR = "Хищник";
    private static final String ANIMAL_HERBAL= "Травоядное";
    private static final List<String> PREDATOR_FOOD = List.of("Животные", "Птицы", "Рыба");
    private static final List<String> HERBAL_FOOD = List.of("Трава", "Различные растения");
    private final String animalType;
    private final List<String> food;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    public  AnimalTests(String animalType, List<String> food) {
        this.animalType= animalType;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {ANIMAL_PREDATOR, PREDATOR_FOOD},
                {ANIMAL_HERBAL, HERBAL_FOOD},

        };
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> actual = animal.getFood(animalType);
        assertEquals("Список не равен ожидаемому результату",
                food, actual);
    }

    @Test
    public void testGetFoodException() {
        Throwable throwable = assertThrows(Exception.class, () -> {
            animal.getFood("unsupported animal kind");
        });
        assertEquals(Exception.class, throwable.getClass());
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", throwable.getMessage());
    }

    @Test
    public void testGetFamily() {
        String actual = animal.getFamily();
        assertEquals("Ответ не соответствует ожидаемому",
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", actual);
    }

}

