package com.market.reporting.formats;

import com.market.products.Food;

import java.util.List;

public class ConsoleFormat extends Format {

    @Override
    public void write(List<Food> foods) {
        for (Food food : foods) {
            System.out.println(food.getName());
        }
    }

    public ConsoleFormat(String name) {
        super(name);
    }
}
