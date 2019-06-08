package com.market.reporting;

import com.market.products.Food;
import com.market.reporting.filters.Filter;
import com.market.reporting.formats.Format;
import com.market.storages.Storage;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class GenerateReport {

    private List<Filter> filteres = new ArrayList<>();
    private List<Format> formats = new ArrayList<>();

    public void report(String filter, List<Storage> storages) {
        String[] filters = filter.split(" ");
        List<Food> foods = fromFilters(storages, filters[1], filters[0]);
        useFormat(foods, filters[2]);
    }

    public List<Food> fromFilters(List<Storage> storages, String filterName, String name) {
        List<Food> foods = new ArrayList<>();
        for (Filter filter : filteres) {
            if (filter.getName().equals(filterName)) {
                foods = filter.decant(storages, name);
                break;
            }
        }
        return foods;
    }

    public void useFormat(List<Food> foods, String formatName) {
        for (Format format : formats) {
            if (format.getName().equals(formatName)) {
                format.write(foods);
                break;
            }
        }
    }

    public void addFilter(Filter nextFilter) {
        filteres.add(nextFilter);
    }

    public void addFormat(Format nextFormat) {
        formats.add(nextFormat);
    }
}
