package com.market.reporting;

import com.market.ControllQualityNext;
import com.market.products.Cheese;
import com.market.products.Pie;
import com.market.reporting.filters.Filter;
import com.market.reporting.filters.FoodFilter;
import com.market.reporting.filters.StorageFilter;
import com.market.reporting.formats.ConsoleFormat;
import com.market.reporting.formats.FileFormat;
import com.market.reporting.formats.Format;
import com.market.storages.Storage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class GenerateReportTest {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintStream outOrigin = System.out;
    private List<Storage> storages = new ArrayList<>();
    ControllQualityNext controllQuality = new ControllQualityNext();
    GenerateReport generateReport = new GenerateReport();
    int year;
    int month;
    int date;

    @Before
    public void setOut() {
        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH);
        date = Calendar.getInstance().get(Calendar.DATE);
        Calendar expaireDate = Calendar.getInstance();
        expaireDate.set(year, month, date - 1);
        Calendar createDate = Calendar.getInstance();
        createDate.set(year, month - 1, date);
        Pie pie_for_trash = new Pie("pie_for_trash", expaireDate, createDate);
        controllQuality.putFoodToStorage(pie_for_trash);
        Calendar expaireDate1 = Calendar.getInstance();
        expaireDate.set(year, month + 1, date);
        Calendar createDate1 = Calendar.getInstance();
        createDate.set(year, month, date - 1);
        Pie pie_for_shop = new Pie("pie_for_Warehause", expaireDate1, createDate1);
        controllQuality.putFoodToStorage(pie_for_shop);
        Calendar expaireDate2 = Calendar.getInstance();
        expaireDate.set(year, month + 1, date);
        Calendar createDate2 = Calendar.getInstance();
        createDate.set(year, month, date - 1);
        Cheese cheese_for_shop = new Cheese("cheese_for_Warehause", expaireDate2, createDate2);
        controllQuality.putFoodToStorage(cheese_for_shop);
        storages = controllQuality.getStorages();
        System.setOut(new PrintStream(out));
        generateReport.addFilter(new FoodFilter("-food"));
        generateReport.addFilter(new StorageFilter("-storage"));
        generateReport.addFormat(new ConsoleFormat("-console"));
        generateReport.addFormat(new FileFormat("-file"));
    }

    @After
    public void setOutOrigin() {
        System.setOut(outOrigin);
        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH);
        date = Calendar.getInstance().get(Calendar.DATE);
    }

    @Test
    public void whenChoseFoodAndWriteInConsole() {
        generateReport.report("pie_for_Warehause -food -console", storages);
        Assert.assertEquals(out.toString(), "pie_for_Warehause" + System.getProperty("line.separator"));
    }

    @Test
    public void whenChoseStorageAndWriteInConsole() {
        generateReport.report("NewWarehouse -storage -console", storages);
        Assert.assertEquals(out.toString(), "pie_for_Warehause" + System.getProperty("line.separator") +
                "cheese_for_Warehause" + System.getProperty("line.separator"));
    }

    @Test
    public void whenChoseFoodAndWriteInFile() {
        generateReport.report("pie_for_trash -food -file", storages);
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("myList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result += line + "\n";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Assert.assertEquals(result, "pie_for_trash\n");
    }
}
