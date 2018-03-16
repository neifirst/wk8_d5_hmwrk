package javatests;

import models.Food;
import models.Meal;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MealTest {

    Meal meal;
    Date date;
    Food food1;
    Food food2;
    Food food3;
    Food food4;
    List<Food> foods;
    Map<Food, Double> ingreds;

    @Before
    public void setUp() throws Exception {

        date = new Date();

        food1 = new Food("Duck eggs", 233, 0, 16.9, 20.4, 0);
        food2 = new Food("Mayonnaise", 720, 1.3, 79, 1.1, 0);
        food3 = new Food("Double cream", 467, 1.6, 50.5, 1.5, 0);
        food4 = new Food("Chedder", 368, 1.8, 30.6, 42.6, 0);

        foods = new ArrayList<Food>();
        ingreds = new HashMap<Food, Double>();

        ingreds.put(food1, 140.0);
        ingreds.put(food2, 15.0);
        ingreds.put(food3, 30.0);

        meal = new Meal("Scrambled Eggs", date, ingreds, foods);
    }

//    @Test
//    public void canGetDate() {
//        assertEquals(42 , meal.getDate());
//    }

    @Test
    public void canAddIngredient() {
        meal.addIngred(food4, 75.0);
        assertEquals(4, meal.getIngredCount());
    }

    @Test
    public void canAddFood() {
        meal.getCalculatedIngred();
        assertEquals(3, meal.getFoodsCount());
    }

}
