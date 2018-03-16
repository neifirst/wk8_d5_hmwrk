package javatests;

import enums.DayType;
import enums.MacroType;
import models.Food;
import models.Meal;
import models.User;
import org.junit.Before;

import java.util.*;

public class UserTest {

    User user;
    Meal meal;
    Date date;
    Food food1;
    Food food2;
    Food food3;
    Food food4;
    List<Food> foods;
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

        foods = new ArrayList<Food>();
        ingreds = new HashMap<Food, Double>();

        ingreds.put(food1, 140.0);
        ingreds.put(food2, 15.0);
        ingreds.put(food3, 30.0);

        meal = new Meal("Scrambled Eggs", date, ingreds, foods);

        savedMeals = new ArrayList<Meal>();

        goals = new HashMap<DayType, Map<MacroType, Double>>();
        monAmounts = new HashMap<MacroType, Double>();

        monAmounts.put(MacroType.CAL, 1500.0);
        monAmounts.put(MacroType.CARBS, 15.0);
        monAmounts.put(MacroType.FAT, 140.0);
        monAmounts.put(MacroType.PROTEIN, 50.0);
        monAmounts.put(MacroType.FIBRE, 5.0);

        goals.put(DayType.MONDAY, monAmounts);

        user = new User("Shia LeBeouf", "ShiCannibal", goals, savedMeals);
    }
}
