package models;

import enums.DayType;
import enums.MacroType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private int id;
    private String name;
    private String userName;
    private Map<DayType, Map<MacroType, Double>> goals;
    private Map<MacroType, Double> monAmounts;
    private List<Meal> savedMeals;

    public User() {
    }

    public User(String name, String userName, Map<DayType, Map<MacroType, Double>> goals, List<Meal> savedMeals) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.goals = goals;
        this.monAmounts = new HashMap<MacroType, Double>();
        this.savedMeals = savedMeals;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<DayType, Map<MacroType, Double>> getGoals() {
        return goals;
    }

    public void setGoals(DayType day, MacroType macro, Double amount) {
        Map<MacroType, Double> map = goals.get(day);
        map.put(macro, amount);

    }

    public void setMonAmounts(MacroType key, Double amount) {
        monAmounts.put(MacroType.CAL, amount);
    }

    public Map<MacroType, Double> getMonAmounts() {
        return monAmounts;
    }


    public List<Meal> getSavedMeals() {
        return savedMeals;
    }

    public void setSavedMeals(List<Meal> savedMeals) {
        this.savedMeals = savedMeals;
    }
}
