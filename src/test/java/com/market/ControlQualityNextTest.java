package com.market;

import com.market.products.Food;
import com.market.products.Pie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class ControlQualityNextTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream outOrigin = System.out;
    int year;
    int month;
    int date;

    @Before
    public void setOut() {
        System.setOut(new PrintStream(out));
        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH);
        date = Calendar.getInstance().get(Calendar.DATE);
    }

    @After
    public void setOrigin() {
        System.setOut(outOrigin);
    }

    @Test
    public void whenReproductToreproductStorage() {
        ControllQualityNext controllQuality = new ControllQualityNext();
        Calendar today = Calendar.getInstance();
        Calendar expaireDate = Calendar.getInstance();
        expaireDate.set(year, month, date - 1);
        Calendar createDate = Calendar.getInstance();
        createDate.set(year, month - 1, date);
        Pie reproduct_pie = new Pie("reproduct pie", expaireDate, createDate);
        controllQuality.getNewFood().setCanReproduct(true);
        controllQuality.putFoodToStorage(reproduct_pie);
        assertEquals(" storage: ReproductStore; food: reproduct pie ; discount: 0" + System.getProperty("line.separator"), out.toString());
    }

    @Test
    public void whenNoWarenToNewStorage() {
        ControllQualityNext controllQuality = new ControllQualityNext();
        Calendar today = Calendar.getInstance();
        Calendar expaireDate = Calendar.getInstance();
        expaireDate.set(year, month + 1, date);
        Calendar createDate = Calendar.getInstance();
        createDate.set(year, month, date - 1);
        Pie pie_for_newWaren = new Pie("pie for newWaren", expaireDate, createDate);
        controllQuality.getNewFood().setFood(pie_for_newWaren);
        controllQuality.putFoodToStorage(pie_for_newWaren);
        assertEquals(" storage: NewWarehouse; food: pie for newWaren ; discount: 0" + System.getProperty("line.separator")
                , out.toString());
    }

    @Test
    public void whenVegetableToRefregerator() {
        ControllQualityNext controllQuality = new ControllQualityNext();
        Calendar today = Calendar.getInstance();
        Calendar expaireDate = Calendar.getInstance();
        expaireDate.set(year, month, date + 12);
        Calendar createDate = Calendar.getInstance();
        createDate.set(year, month, date - 1);
        Food vegetable = new Food("vegetable", expaireDate, createDate);
        controllQuality.getNewFood().setVegetable(true);
        controllQuality.putFoodToStorage(vegetable);
        assertEquals(" storage: LowTemperatureStore; food: vegetable ; discount: 0" + System.getProperty("line.separator"),
                out.toString());
    }

    @Test
    public void checkResort() {
        ControllQualityNext controllQuality = new ControllQualityNext();
        Calendar today = Calendar.getInstance();
        Calendar expaireDate = Calendar.getInstance();
        expaireDate.set(year, month, date - 1);
        Calendar createDate = Calendar.getInstance();
        createDate.set(year, month, date - 3);
        Pie pie_for_trash = new Pie("pie for trash", expaireDate, createDate);
        controllQuality.putFoodToStorage(pie_for_trash);
        //assertEquals(" storage: Trash; food: pie for trash ; discount: 0" + System.getProperty("line.separator"), out.toString());
        Calendar newExpaireDate = Calendar.getInstance();
        newExpaireDate.set(year, month, date + 3);
        pie_for_trash.setExpaireDate(newExpaireDate);
        controllQuality.resort();
        assertEquals(" storage: Trash; food: pie for trash ; discount: 0" + System.getProperty("line.separator") +
                " storage: Shop; food: pie for trash ; discount: 0" + System.getProperty("line.separator") +
                "remove from storage: Trash; food: pie for trash" + System.getProperty("line.separator"), out.toString());
    }
}
