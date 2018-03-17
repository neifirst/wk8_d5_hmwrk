package dbtests;

import db.DBHelper;
import models.Food;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FoodTestDb {

    private Food food1;


    @Before
    public void setUp() throws Exception {
        food1 = new Food("Mayonnaise", 720, 1.3, 79, 1.1, 0);
        DBHelper.save(food1);
    }


    @Test
    public void canSave() {
        List<Food> results = DBHelper.getAll(Food.class);
        assertEquals(1, results.size());
    }

    @Test
    public void canUpdate() {
        Food found = DBHelper.find(Food.class, food1.getId());
        found.setName("Helmanns Mayo");
        DBHelper.save(found);
        found = DBHelper.find(Food.class, food1.getId());
        assertEquals("Helmanns Mayo", found.getName());
    }



}
