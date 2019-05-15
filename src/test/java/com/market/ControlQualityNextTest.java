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
        expaireDate.set(2019, 4, 14);
        Calendar createDate = Calendar.getInstance();
        createDate.set(2019, 4, 11);
        Pie reproduct_pie = new Pie("reproduct pie", expaireDate, createDate);
        controllQuality.getNewFood().setCanReproduct(true);
        controllQuality.putFoodToStorage(reproduct_pie);
        assertEquals(" storage: Trash; food: reproduct pie ; discount: 0" + System.getProperty("line.separator")+
                "removed from Trash" + System.getProperty("line.separator")+" reproductStorage: Warehouse; food: reproduct pie ; discount: 0"+
                System.getProperty("line.separator"), out.toString());
    }

    @Test
    public void whenNoWarenToNewStorage() {
        ControllQualityNext controllQuality = new ControllQualityNext();
        Calendar today = Calendar.getInstance();
        Calendar expaireDate = Calendar.getInstance();
        expaireDate.set(2019, 4, 24);
        Calendar createDate = Calendar.getInstance();
        createDate.set(2019, 4, 14);
        Pie pie_for_newWaren = new Pie("pie for newWaren", expaireDate, createDate);
        controllQuality.getNewFood().setFood(pie_for_newWaren);
        controllQuality.putFoodToStorage(pie_for_newWaren);
        assertEquals(" storage: Warehouse; food: pie for newWaren ; discount: 0" + System.getProperty("line.separator")+
                "to New storage: Warehouse; food: pie for newWaren ; discount: 0" + System.getProperty("line.separator"), out.toString());
    }

    @Test
    public void whenVegetableToRefregerator() {
        ControllQualityNext controllQuality = new ControllQualityNext();
        Calendar today = Calendar.getInstance();
        Calendar expaireDate = Calendar.getInstance();
        expaireDate.set(2019, 4, 17);
        Calendar createDate = Calendar.getInstance();
        createDate.set(2019, 4, 11);
        Food vegetable = new Food("vegetable", expaireDate, createDate);
        controllQuality.getNewFood().setVegetable(true);
        controllQuality.putFoodToStorage(vegetable);
        assertEquals(" storage: Shop; food: vegetable ; discount: 13" + System.getProperty("line.separator")+
                " refregeratorStorage: Warehouse; food: vegetable ; discount: 13" + System.getProperty("line.separator"), out.toString());
    }
}
