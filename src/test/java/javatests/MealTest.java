package javatests;

import models.Food;
import models.Meal;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MealTest {

    Meal meal;
    Food food1;
    Food food2;
    Food food3;
    Food food4;
    List<Food> foods;
    Map<Food, Double> ingreds;

    @Before
    public void setUp() throws Exception {
        food1 = new Food("Duck eggs", 233, 0, 16.9, 20.4, 0);
        food2 = new Food("Mayonnaise", 720, 1.3, 79, 1.1, 0);
        food3 = new Food("Double cream", 467, 1.6, 50.5, 1.5, 0);
        food4 = new Food("Chedder", 368, 1.8, 30.6, 42.6, 0);

        foods = new ArrayList<Food>();
        ingreds = new HashMap<Food, Double>();

        foods.add(food1);
        foods.add(food2);
        foods.add(food3);

        ingreds.put(food1, 140.0);
        ingreds.put(food2, 15.0);
        ingreds.put(food2, 30.0);

        meal = new Meal("Scrambled Eggs", ingreds, foods);
    }

    @Test
    public void canAddFood() {
        meal.addFood(food4);
        assertEquals(4, meal.getFoodsCount());
    }

    @Test
    public void canAddIngredient() {
        meal.addIngredient(food4);
        assertEquals(4, meal.getIngredCount());
    }

    //    @Test
//    public void canGetCalculatedIngred() {
//        meal.getCalculateIngred();
//        assertEquals(376, meal.getCalories(), 0.01);
//    }
}
