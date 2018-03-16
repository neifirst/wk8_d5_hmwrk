package models;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private int id;
    private String name;
    private List<Food> foods;
    private double calories;
    private double carbs;
    private double fat;
    private double protein;
    private double fibre;

    public Meal() {
    }

    public Meal(String name, List<Food> foods) {
        this.id = id;
        this.name = name;
        this.foods = foods;
        this.calories = calories;
        this.carbs = carbs;
        this.fat = fat;
        this.protein = protein;
        this.fibre = fibre;
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

    public int getFoodsCount() {
        return foods.size();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFibre() {
        return fibre;
    }

    public void setFibre(double fibre) {
        this.fibre = fibre;
    }


}
