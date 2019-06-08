package com.market.reporting.formats;

import com.market.products.Food;

import java.util.List;

public abstract class Format {

    protected String name;

    public abstract void write(List<Food> foods);

    public Format() {
    }

    public Format(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
