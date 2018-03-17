package dbtests;

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

public class MealTestDb {

    private Food food1;
    private Food food2;
    private Food food3;
    private Food food4;
    private Food food5;
    private Meal meal;
    private User user;
    private Date date;
    List<Food> constituents;
    Map<Food, Double> ingreds;
    Map<DayType, Map<MacroType, Double>> goals;
    Map<MacroType, Double> monAmounts;
    List<Meal> savedMeals;


    @Before
    public void setUp() throws Exception {

        date = new Date();

        food1 = new Food("Duck eggs", 233, 0, 16.9, 20.4, 0);
        DBHelper.save(food1);
        food2 = new Food("Mayonnaise", 720, 1.3, 79, 1.1, 0);
        DBHelper.save(food2);
        food3 = new Food("Double cream", 467, 1.6, 50.5, 1.5, 0);
        DBHelper.save(food3);
        food4 = new Food("Chedder", 368, 1.8, 30.6, 42.6, 0);
        DBHelper.save(food4);
        food5 = new Food("All the bodies", 2678, 3.6, 363.2, 684, 0);
        DBHelper.save(food5);

        constituents = new ArrayList<>();
        ingreds = new HashMap<>();

        ingreds.put(food1, 140.0);
        ingreds.put(food2, 15.0);
        ingreds.put(food3, 30.0);

        savedMeals = new ArrayList<>();


        goals = new HashMap<>();
        monAmounts = new HashMap<>();

        monAmounts.put(MacroType.CAL, 1500.0);
        monAmounts.put(MacroType.CARBS, 15.0);
        monAmounts.put(MacroType.FAT, 140.0);
        monAmounts.put(MacroType.PROTEIN, 50.0);
        monAmounts.put(MacroType.FIBRE, 5.0);

        goals.put(DayType.MONDAY, monAmounts);



        user = new User("Shia LeBeouf", "ShiCannibal", goals, savedMeals);
        DBHelper.save(user);

        meal = new Meal("Scrambled Eggs", user, date, ingreds, constituents);
        DBHelper.save(meal);

    }


    @Test
    public void canSave() {
        List<Meal> results = DBHelper.getAll(Meal.class);
        assertEquals(1, results.size());
    }

    @Test
    public void canUpdate() {
        Meal found = DBHelper.find(Meal.class, meal.getId());
        found.setName("Scrambled Eggies");
        DBHelper.save(found);
        found = DBHelper.find(Meal.class, meal.getId());
        assertEquals("Scrambled Eggies", found.getName());
    }

}
