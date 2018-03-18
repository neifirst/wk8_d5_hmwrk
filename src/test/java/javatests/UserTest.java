package javatests;

import db.DBHelper;
import enums.DayType;
import enums.MacroType;
import models.Food;
import models.Meal;
import models.User;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class UserTest {

    User user;
    Meal meal;
    Date date;
    Food food1;
    Food food2;
    Food food3;
    Food food4;
    Food food5;
    List<Food> constituents;
    Map<Food, Double> ingreds;
    Map<DayType, Map<MacroType, Double>> goals;
    List<Meal> savedMeals;


    @Before
    public void setUp() throws Exception {


        date = new Date();

        food1 = new Food("Duck eggs", 233, 0, 16.9, 20.4, 0);
        food2 = new Food("Mayonnaise", 720, 1.3, 79, 1.1, 0);
        food3 = new Food("Double cream", 467, 1.6, 50.5, 1.5, 0);
        food4 = new Food("Chedder", 368, 1.8, 30.6, 42.6, 0);
        food5 = new Food("All the bodies", 2678, 3.6, 363.2, 684, 0);

        constituents = new ArrayList<>();

        ingreds = new HashMap<>();

        meal = new Meal("Scrambled Eggs", user, date, ingreds, constituents);

        savedMeals = new ArrayList<>();

        goals = new HashMap<>();

        user = new User("Shia LeBeouf", "ShiCannibal", goals, savedMeals);

    }



    @Test
    public void canAddMeal() {
        user.addMeal(meal);
        assertEquals(1, user.mealCount());
    }

    @Test
    public void canFindMealsByDay() {
        user.addMeal(meal);
        List<Meal> found = user.findMealsByDay(DayType.SUNDAY);
        assertEquals(1, found.size());
    }

    @Test
    public void canPopulateStartingGoals() {
        user.populateStartingGoals();
        assertEquals(7, user.getGoals().size());
        Map<MacroType, Double> map = goals.get(DayType.MONDAY);
        Double result = map.get(MacroType.CAL);
        assertEquals(1500.0, result, 0.01);

    }

        @Test
    public void canUpdateAGoal() {
        user.populateStartingGoals();
        user.setGoals(DayType.MONDAY, MacroType.CAL, 1600.0);
        Map<MacroType, Double> map = goals.get(DayType.MONDAY);
        Double result = map.get(MacroType.CAL);
        assertEquals(1600.0, result, 0.01);
    }


}
