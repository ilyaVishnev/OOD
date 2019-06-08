package com.market.reporting.filters;

import com.market.products.Food;
import com.market.storages.Storage;

import java.util.ArrayList;
import java.util.List;

public abstract class Filter {

    protected String name;

    public abstract List<Food> decant(List<Storage> storages, String parameter);

    public Filter() {
    }

    public Filter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
