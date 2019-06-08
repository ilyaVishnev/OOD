package com.market.reporting.formats;

import com.market.products.Food;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class FileFormat extends Format {

    @Override
    public void write(List<Food> foods) {
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream("myList.txt"), true)) {
            for (Food food : foods) {
                printWriter.println(food.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public FileFormat(String name) {
        super(name);
    }
}
