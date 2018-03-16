package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meal {

    private int id;
    private String name;
    private Map<Food, Double> ingreds;
    private List<Food> foods;
    private double calTotal;
    private double carbsTotal;
    private double fatTotal;
    private double proteinTotal;
    private double fibreTotal;

    public Meal() {
    }

    public Meal(String name, Map<Food, Double> ingreds, List<Food> foods) {
        this.id = id;
        this.name = name;
        this.ingreds = ingreds;
        this.foods = foods;
        this.calTotal = 0;
        this.carbsTotal = 0;
        this.fatTotal = 0;
        this.proteinTotal = 0;
        this.fibreTotal = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Map<Food, Double> getIngreds() {
        return ingreds;
    }

    public void setIngreds(Map<Food, Double> ingreds) {
        this.ingreds = ingreds;
    }

    public int getFoodsCount() {
        return foods.size();
    }

    public void addFood(Food food) {
        foods.add(food);
    }



    public void getCalculateIngred() {
        for (Food key : ingreds.keySet()) {
           double calResult = key.getCalories() * (ingreds.get(key) / 100);
           double carbResult = key.getCalories() * (ingreds.get(key) / 100);
           double fatResult = key.getCalories() * (ingreds.get(key) / 100);
           double proteinResult = key.getCalories() * (ingreds.get(key) / 100);
           double fibreResult = key.getCalories() * (ingreds.get(key) / 100);

           calTotal += calResult;
           carbsTotal += carbResult;
           fatTotal += fatResult;
           proteinTotal += proteinResult;
           fibreTotal += fibreResult;
        }
    }

    public int getIngredCount() {
        return ingreds.size();
    }

    public void addIngred(Food food, double grams) {
        ingreds.put(food, grams);
    }
}
