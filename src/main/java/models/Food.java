package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="meals")
public class Food {

    private int id;
    private String name;
    private double calories;
    private double fat;
    private double carbs;
    private double protein;
    private double fibre;
    private List<Meal> meals;

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
        this.meals = new ArrayList<>();
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="cal")
    public double getCalories() {
        return calories;
    }

    public void setCalories(double  calories) {
        this.calories = calories;
    }

    @Column(name="fat")
    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Column(name="carbs")
    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    @Column(name="protein")
    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    @Column(name="fibre")
    public double getFibre() {
        return fibre;
    }

    public void setFibre(double fibre) {
        this.fibre = fibre;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "foods")
    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
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
