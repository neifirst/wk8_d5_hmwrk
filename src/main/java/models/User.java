package models;

import enums.DayType;
import enums.MacroType;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="users")
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

    @Column(name="user_name")
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

    public void setMonAmounts(MacroType macro, Double amount) {
        monAmounts.put(macro, amount);
    }

    public Map<MacroType, Double> getMonAmounts() {
        return monAmounts;
    }

    @OneToMany(mappedBy="user",fetch= FetchType.EAGER)
    public List<Meal> getSavedMeals() {
        return savedMeals;
    }

    public void setSavedMeals(List<Meal> savedMeals) {
        this.savedMeals = savedMeals;
    }

    public void addMeal(Meal meal) {
        savedMeals.add(meal);
    }

    public int mealCount() {
        return savedMeals.size();
    }
}
