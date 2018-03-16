package models;

import java.util.*;

public class Meal {

    private int id;
    private String name;
    private Date date;
    private Map<Food, Double> ingreds;
    private List<Food> foods;
    private double calTotal;
    private double carbsTotal;
    private double fatTotal;
    private double proteinTotal;
    private double fibreTotal;

    public Meal() {
    }

    public Meal(String name, Date date, Map<Food, Double> ingreds, List<Food> foods) {
        this.id = id;
        this.name = name;
        this.date = new Date();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getIngredCount() {
        return ingreds.size();
    }

    public void addIngred(Food food, double grams) {
        ingreds.put(food, grams);
    }



    public void getCalculatedIngred() {
        for (Food key : ingreds.keySet()) {
           double calResult = key.getCalories() * (ingreds.get(key) / 100);
           double carbResult = key.getCarbs() * (ingreds.get(key) / 100);
           double fatResult = key.getFat() * (ingreds.get(key) / 100);
           double proteinResult = key.getProtein() * (ingreds.get(key) / 100);
           double fibreResult = key.getFibre() * (ingreds.get(key) / 100);

           calTotal += calResult;
           carbsTotal += carbResult;
           fatTotal += fatResult;
           proteinTotal += proteinResult;
           fibreTotal += fibreResult;

           Food food = new Food(key.getName(), calResult, carbResult, fatResult, proteinResult, fibreResult);
           this.addFood(food);
        }
    }

    public double getCalTotal() {
        return calTotal;
    }

    public void setCalTotal(double calTotal) {
        this.calTotal = calTotal;
    }

    public double getCarbsTotal() {
        return carbsTotal;
    }

    public void setCarbsTotal(double carbsTotal) {
        this.carbsTotal = carbsTotal;
    }

    public double getFatTotal() {
        return fatTotal;
    }

    public void setFatTotal(double fatTotal) {
        this.fatTotal = fatTotal;
    }

    public double getProteinTotal() {
        return proteinTotal;
    }

    public void setProteinTotal(double proteinTotal) {
        this.proteinTotal = proteinTotal;
    }

    public double getFibreTotal() {
        return fibreTotal;
    }

    public void setFibreTotal(double fibreTotal) {
        this.fibreTotal = fibreTotal;
    }
}
