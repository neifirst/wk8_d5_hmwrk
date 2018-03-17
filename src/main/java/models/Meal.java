package models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="meals")
public class Meal {

    private int id;
    private String name;
    private User user;
    private Date date;
    private Map<Food, Double> ingreds;
    private List<Food> constituents;
    private double calTotal;
    private double carbsTotal;
    private double fatTotal;
    private double proteinTotal;
    private double fibreTotal;

    public Meal() {
    }

    public Meal(String name, User user, Date date, Map<Food, Double> ingreds, List<Food> constituents) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.date = new Date();
        this.ingreds = ingreds;
        this.constituents = constituents;
        this.calTotal = 0;
        this.carbsTotal = 0;
        this.fatTotal = 0;
        this.proteinTotal = 0;
        this.fibreTotal = 0;
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

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name="date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Transient
    public List<Food> getConstituents() {
        return constituents;
    }

    public void setFoods(List<Food> constituents) {
        this.constituents = constituents;
    }

    @Transient
    public Map<Food, Double> getIngreds() {
        return ingreds;
    }


    public void setIngreds(Map<Food, Double> ingreds) {
        this.ingreds = ingreds;
    }

    public int constituentsCount() {
        return constituents.size();
    }


    public void addConstituent(Food constituent) {
        constituents.add(constituent);
    }

    public int ingredCount() {
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

           Food constituent = new Food(key.getName(), calResult, carbResult, fatResult, proteinResult, fibreResult);
           this.addConstituent(constituent);
        }
    }

    @Column(name="cal")
    public double getCalTotal() {
        return calTotal;
    }

    public void setCalTotal(double calTotal) {
        this.calTotal = calTotal;
    }

    @Column(name="carbs")
    public double getCarbsTotal() {
        return carbsTotal;
    }

    public void setCarbsTotal(double carbsTotal) {
        this.carbsTotal = carbsTotal;
    }

    @Column(name="fat")
    public double getFatTotal() {
        return fatTotal;
    }

    public void setFatTotal(double fatTotal) {
        this.fatTotal = fatTotal;
    }

    @Column(name="protein")
    public double getProteinTotal() {
        return proteinTotal;
    }

    public void setProteinTotal(double proteinTotal) {
        this.proteinTotal = proteinTotal;
    }

    @Column(name="fibre")
    public double getFibreTotal() {
        return fibreTotal;
    }

    public void setFibreTotal(double fibreTotal) {
        this.fibreTotal = fibreTotal;
    }
}
