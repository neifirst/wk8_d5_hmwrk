package models;

import enums.DayType;
import enums.MacroType;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="users")
public class User {

    private int id;
    private String name;
    private String userName;
    private Map<DayType, Map<MacroType, Double>> goals;
    private Map<MacroType, Double> monGoals;
    private Map<MacroType, Double> tueGoals;
    private Map<MacroType, Double> wedGoals;
    private Map<MacroType, Double> thuGoals;
    private Map<MacroType, Double> friGoals;
    private Map<MacroType, Double> satGoals;
    private Map<MacroType, Double> sunGoals;
    private List<Meal> savedMeals;

    public User() {
    }

    public User(String name, String userName, Map<DayType, Map<MacroType, Double>> goals, List<Meal> savedMeals) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.goals = goals;
        this.monGoals = new HashMap<>();
        this.tueGoals = new HashMap<>();
        this.wedGoals = new HashMap<>();
        this.thuGoals = new HashMap<>();
        this.friGoals = new HashMap<>();
        this.satGoals = new HashMap<>();
        this.sunGoals = new HashMap<>();
        this.savedMeals = savedMeals;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Transient
    public Map<DayType, Map<MacroType, Double>> getGoals() {
        return goals;
    }

    public void setGoals(DayType day, MacroType macro, Double amount) {
        Map<MacroType, Double> map = goals.get(day);
        map.put(macro, amount);

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


    public List<Meal> findMealsByDay(DayType day) {
        List<Meal> found = new ArrayList<>();
        for (Meal item : savedMeals) {
            if (item.getDate().get(GregorianCalendar.DAY_OF_WEEK) == day.getTag()) {
                found.add(item);
            }
        }
        return found;
    }



    public void populateStartingGoals() {
        Double amount;
        for (DayType day : DayType.values()) {
            if (day == DayType.MONDAY) {
                for (MacroType macro : MacroType.values()) {
                    if (macro == MacroType.CAL) {
                        amount = 1500.0;
                        this.monGoals.put(macro, amount);
                    }else if (macro == MacroType.CARBS) {
                        amount = 15.0;
                        this.monGoals.put(macro, amount);
                    }else if (macro == MacroType.FAT) {
                        amount = 130.0;
                        this.monGoals.put(macro, amount);
                    }else if (macro == MacroType.PROTEIN) {
                        amount = 50.0;
                        this.monGoals.put(macro, amount);
                    }else if (macro == MacroType.FIBRE) {
                        amount = 5.0;
                        this.monGoals.put(macro, amount);
                    }
                }
                this.goals.put(day, monGoals);

            } else if (day == DayType.TUESDAY) {
                for (MacroType macro : MacroType.values()) {
                    if (macro == MacroType.CAL) {
                        amount = 1500.0;
                        this.tueGoals.put(macro, amount);
                    }else if (macro == MacroType.CARBS) {
                        amount = 15.0;
                        this.tueGoals.put(macro, amount);
                    }else if (macro == MacroType.FAT) {
                        amount = 130.0;
                        this.tueGoals.put(macro, amount);
                    }else if (macro == MacroType.PROTEIN) {
                        amount = 50.0;
                        this.tueGoals.put(macro, amount);
                    }else if (macro == MacroType.FIBRE) {
                        amount = 5.0;
                        this.tueGoals.put(macro, amount);
                    }
                }
                this.goals.put(day, tueGoals);

            } else if (day == DayType.WEDNESDAY) {
                for (MacroType macro : MacroType.values()) {
                    if (macro == MacroType.CAL) {
                        amount = 1500.0;
                        this.wedGoals.put(macro, amount);
                    }else if (macro == MacroType.CARBS) {
                        amount = 15.0;
                        this.wedGoals.put(macro, amount);
                    }else if (macro == MacroType.FAT) {
                        amount = 130.0;
                        this.wedGoals.put(macro, amount);
                    }else if (macro == MacroType.PROTEIN) {
                        amount = 50.0;
                        this.wedGoals.put(macro, amount);
                    }else if (macro == MacroType.FIBRE) {
                        amount = 5.0;
                        this.wedGoals.put(macro, amount);
                    }
                }
                this.goals.put(day, wedGoals);

            } else if (day == DayType.THURSDAY) {
                for (MacroType macro : MacroType.values()) {
                    if (macro == MacroType.CAL) {
                        amount = 1500.0;
                        this.thuGoals.put(macro, amount);
                    }else if (macro == MacroType.CARBS) {
                        amount = 15.0;
                        this.thuGoals.put(macro, amount);
                    }else if (macro == MacroType.FAT) {
                        amount = 130.0;
                        this.thuGoals.put(macro, amount);
                    }else if (macro == MacroType.PROTEIN) {
                        amount = 50.0;
                        this.thuGoals.put(macro, amount);
                    }else if (macro == MacroType.FIBRE) {
                        amount = 5.0;
                        this.thuGoals.put(macro, amount);
                    }
                }
                this.goals.put(day, thuGoals);

            } else if (day == DayType.FRIDAY) {
                for (MacroType macro : MacroType.values()) {
                    if (macro == MacroType.CAL) {
                        amount = 1500.0;
                        this.friGoals.put(macro, amount);
                    }else if (macro == MacroType.CARBS) {
                        amount = 15.0;
                        this.friGoals.put(macro, amount);
                    }else if (macro == MacroType.FAT) {
                        amount = 130.0;
                        this.friGoals.put(macro, amount);
                    }else if (macro == MacroType.PROTEIN) {
                        amount = 50.0;
                        this.friGoals.put(macro, amount);
                    }else if (macro == MacroType.FIBRE) {
                        amount = 5.0;
                        this.friGoals.put(macro, amount);
                    }
                }
                this.goals.put(day, friGoals);

            } else if (day == DayType.SATURDAY) {
                for (MacroType macro : MacroType.values()) {
                    if (macro == MacroType.CAL) {
                        amount = 1500.0;
                        this.satGoals.put(macro, amount);
                    }else if (macro == MacroType.CARBS) {
                        amount = 15.0;
                        this.satGoals.put(macro, amount);
                    }else if (macro == MacroType.FAT) {
                        amount = 130.0;
                        this.satGoals.put(macro, amount);
                    }else if (macro == MacroType.PROTEIN) {
                        amount = 50.0;
                        this.satGoals.put(macro, amount);
                    }else if (macro == MacroType.FIBRE) {
                        amount = 5.0;
                        this.satGoals.put(macro, amount);
                    }
                }
                this.goals.put(day, satGoals);

            } else if (day == DayType.SUNDAY) {
                for (MacroType macro : MacroType.values()) {
                    if (macro == MacroType.CAL) {
                        amount = 1500.0;
                        this.sunGoals.put(macro, amount);
                    }else if (macro == MacroType.CARBS) {
                        amount = 15.0;
                        this.sunGoals.put(macro, amount);
                    }else if (macro == MacroType.FAT) {
                        amount = 130.0;
                        this.sunGoals.put(macro, amount);
                    }else if (macro == MacroType.PROTEIN) {
                        amount = 50.0;
                        this.sunGoals.put(macro, amount);
                    }else if (macro == MacroType.FIBRE) {
                        amount = 5.0;
                        this.sunGoals.put(macro, amount);
                    }
                }
                this.goals.put(day, sunGoals);
            }

        }

    }
}
