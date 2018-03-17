import db.DBHelper;
import enums.DayType;
import enums.MacroType;
import models.Food;
import models.Meal;
import models.User;

import java.util.*;

public class runner {


    public static void main(String[] args) {

        Date date = new Date();

        Food food1 = new Food("Duck eggs", 233, 0, 16.9, 20.4, 0);
        DBHelper.save(food1);
        Food food2 = new Food("Mayonnaise", 720, 1.3, 79, 1.1, 0);
        DBHelper.save(food2);
        Food food3 = new Food("Double cream", 467, 1.6, 50.5, 1.5, 0);
        DBHelper.save(food3);
        Food food4 = new Food("Chedder", 368, 1.8, 30.6, 42.6, 0);
        DBHelper.save(food4);
        Food food5 = new Food("All the bodies", 2678, 3.6, 363.2, 684, 0);
        DBHelper.save(food5);

        List<Food> foods = new ArrayList<>();
        Map<Food, Double> ingreds = new HashMap<>();

        ingreds.put(food1, 140.0);
        ingreds.put(food2, 15.0);
        ingreds.put(food3, 30.0);

        List<Meal> savedMeals = new ArrayList<>();

        Map<DayType, Map<MacroType, Double>> goals = new HashMap<>();
        Map<MacroType, Double> monAmounts = new HashMap<>();


        User user1 = new User("Shia LeBeouf", "ShiCannibal", goals, savedMeals);
        DBHelper.save(user1);

        Meal meal1 = new Meal("Scrambled Eggs", user1, date, ingreds, foods);
        DBHelper.save(meal1);

        List<Food> allFoods = DBHelper.getAll(Food.class);
    }
}
