package models;

public class Food {

    private int id;
    private String name;
    private double calories;
    private double fat;
    private double carbs;
    private double protein;
    private double fibre;

    public Food() {
    }

    public Food(String name, double calories, double carbs, double fat, double protein, double fibre) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
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

    public double getCalories() {
        return calories;
    }

    public void setCalories(double  calories) {
        this.calories = calories;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
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

    public Food getValuesForAmount(double grams) {
        double gramsCon = grams / 100;
        double newCals = (this.getCalories() * (gramsCon));
        double newCarbs = (this.getCarbs() * gramsCon);
        double newFat = (this.getFat() * gramsCon);
        double newProtein = (this.getProtein() * gramsCon);
        double newFibre = (this.getFibre() * gramsCon);
        Food newFood = new Food(this.getName(), newCals, newCarbs, newFat, newProtein, newFibre);

        return newFood;
    }
}
