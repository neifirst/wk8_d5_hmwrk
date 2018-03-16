package javatests;

import models.Food;
import models.Meal;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MealTest {

    Meal meal;
    Food food1;
    Food food2;
    Food food3;
    List<Food> foods;

    @Before
    public void setUp() throws Exception {
        food1 = new Food("Duck eggs", 233, 0, 16.9, 20.4, 0);
        food2 = new Food("Mayonnaise", 720, 1.3, 79, 1.1, 0);
        food3 = new Food("Double cream", 467, 1.6, 50.5, 1.5, 0);
        foods = new ArrayList<Food>();

        foods.add(food1);
        foods.add(food2);

        meal = new Meal("Scrambled Eggs", foods);
    }

    @Test
    public void canAddFood() {
        meal.addFood(food3);
        assertEquals(3, meal.getFoodsCount());
    }

    @Test
    public void canGetTotalValues() {
        Meal newMeal = meal.getTotalValues();
        assertEquals(376, newFood.getCalories(), 0.01);
    }
}
