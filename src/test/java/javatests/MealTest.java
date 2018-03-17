package javatests;

import enums.DayType;
import enums.MacroType;
import models.Food;
import models.Meal;
import models.User;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MealTest {

    Meal meal;
    User user;
    Date date;
    Food food1;
    Food food2;
    Food food3;
    Food food4;
    List<Food> constituents;
    Map<Food, Double> ingreds;
    Map<DayType, Map<MacroType, Double>> goals;
    Map<MacroType, Double> monAmounts;
    List<Meal> savedMeals;

    @Before
    public void setUp() throws Exception {

        date = new Date();


        food1 = new Food("Duck eggs", 233, 0, 16.9, 20.4, 0);
        food2 = new Food("Mayonnaise", 720, 1.3, 79, 1.1, 0);
        food3 = new Food("Double cream", 467, 1.6, 50.5, 1.5, 0);
        food4 = new Food("Chedder", 368, 1.8, 30.6, 42.6, 0);

        constituents = new ArrayList<Food>();
        ingreds = new HashMap<Food, Double>();

        ingreds.put(food1, 140.0);
        ingreds.put(food2, 15.0);
        ingreds.put(food3, 30.0);

        savedMeals = new ArrayList<>();

        goals = new HashMap<>();
        monAmounts = new HashMap<>();

        user = new User("Shia LeBeouf", "ShiCannibal", goals, savedMeals);


        meal = new Meal("Scrambled Eggs", user, date, ingreds, constituents);
    }

//    @Test
//    public void canGetDate() {
//        assertEquals(42 , meal.getDate());
//    }

    @Test
    public void canAddIngredientAndCalculate() {
        meal.addIngred(food4, 75.0);
        assertEquals(4, meal.ingredCount());
    }


}
