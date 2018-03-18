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




        List<Food> constituents = new ArrayList<>();
        Map<Food, Double> ingreds = new HashMap<>();

        ingreds.put(food1, 140.0);
        ingreds.put(food2, 15.0);
        ingreds.put(food3, 30.0);

        List<Meal> savedMeals = new ArrayList<>();




        Map<DayType, Map<MacroType, Double>> goals = new HashMap<>();
        Map<MacroType, Double> monGoals = new HashMap<>();
        Map<MacroType, Double> tueGoals = new HashMap<>();
        Map<MacroType, Double> wedGoals = new HashMap<>();
        Map<MacroType, Double> thuGoals = new HashMap<>();
        Map<MacroType, Double> friGoals = new HashMap<>();
        Map<MacroType, Double> satGoals = new HashMap<>();
        Map<MacroType, Double> sunGoals = new HashMap<>();




        User user1 = new User("Shia LeBeouf", "ShiCannibal", goals, savedMeals);
        DBHelper.save(user1);

        Meal meal1 = new Meal("Scrambled Eggs", user1, date, ingreds, constituents);
        meal1.getCalculatedIngred();
        DBHelper.save(meal1);



        user1.populateStartingGoals();
        user1.addMeal(meal1);
        user1.setGoals(DayType.MONDAY, MacroType.CAL, 1600.0);




        DBHelper.delete(food5);
        DBHelper.delete(food2);

        user1.setUserName("funky_shi_shi");
        DBHelper.save(user1);

        List<Food> allFoods = DBHelper.getAll(Food.class);
        List<Meal> allMeals = DBHelper.getAll(Meal.class);
        List<User> allUsers = DBHelper.getAll(User.class);

        Food foundFoodById = DBHelper.find(Food.class, food2.getId());
        Meal foundMealById = DBHelper.find(Meal.class, meal1.getId());
        User foundUserById = DBHelper.find(User.class, user1.getId());

//        List<Food> foundFoodsByMeal = DBHelper.getFoodsByMeal(meal1); <--- MANY TO MANY HASH PROBLEM

        List<Meal> foundMealsByUser = DBHelper.getMealsByUser(user1);
        List<Meal> foundMealsByDay = user1.findMealsByDay(DayType.SUNDAY);


    }
}
