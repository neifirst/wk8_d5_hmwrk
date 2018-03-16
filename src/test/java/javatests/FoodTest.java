package javatests;

import models.Food;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodTest {

    Food food;

    @Before
    public void setUp() throws Exception {
        food = new Food("Macadamia Nuts", 752, 5.2, 75.8, 7.9, 8.6);
    }

    @Test
    public void canGetPercentValues() {
        Food newFood = food.getValuesForAmount(50);
        assertEquals(376, newFood.getCalories(), 0.01);
        assertEquals(2.6, newFood.getCarbs(), 0.01);
        assertEquals(37.9, newFood.getFat(), 0.01);
        assertEquals(3.95, newFood.getProtein(), 0.01);
        assertEquals(4.3, newFood.getFibre(), 0.01);
    }
}
