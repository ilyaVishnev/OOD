package com.market;

import com.market.products.Food;
import com.market.products.Pie;
import com.market.storages.Shop;
import com.market.storages.Trash;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class ControlQualityTest {

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
    public void whenAddPieToShop() {
        ControllQuality controllQuality = new ControllQuality();
        Calendar today = Calendar.getInstance();
        Calendar expaireDate = Calendar.getInstance();
        expaireDate.set(year, month, date + 1);
        Calendar createDate = Calendar.getInstance();
        createDate.set(year, month, date - 1);
        Food pie = new Pie("pie for shop", expaireDate, createDate);
        controllQuality.putFoodToStorage(pie);
        assertEquals(" storage: Shop; food: pie for shop ; discount: 0" + System.getProperty("line.separator"), out.toString());
    }

    @Test
    public void whenAddPieToTrash() {
        ControllQuality controllQuality = new ControllQuality();
        Calendar today = Calendar.getInstance();
        Calendar expaireDate = Calendar.getInstance();
        expaireDate.set(year, month, date - 1);
        Calendar createDate = Calendar.getInstance();
        createDate.set(year, month, date - 3);
        Pie pie_for_trash = new Pie("pie for trash", expaireDate, createDate);
        controllQuality.putFoodToStorage(pie_for_trash);
        assertEquals(" storage: Trash; food: pie for trash ; discount: 0" + System.getProperty("line.separator"), out.toString());
    }

    @Test
    public void whenAddCheeseToShop() {
        ControllQuality controllQuality = new ControllQuality();
        Calendar today = Calendar.getInstance();
        Calendar expaireDate = Calendar.getInstance();
        expaireDate.set(year, month, date + 1);
        Calendar createDate = Calendar.getInstance();
        createDate.set(year, month, date - 4);
        Pie pie_for_shop = new Pie("pie for shop wit discount", expaireDate, createDate);
        controllQuality.putFoodToStorage(pie_for_shop);
        assertEquals(" storage: Shop; food: pie for shop wit discount ; discount: 13" + System.getProperty("line.separator"), out.toString());
    }
}
