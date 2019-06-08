package com.market.reporting.filters;

import com.market.products.Food;
import com.market.storages.Storage;

import java.util.ArrayList;
import java.util.List;

public class StorageFilter extends Filter {

    @Override
    public List<Food> decant(List<Storage> storages, String parameter) {
        List<Food> foodResult = new ArrayList<>();
        for (Storage storage : storages) {
            if (storage.getClass().getSimpleName().equals(parameter)) {
                for (Food food : storage.getFoods()) {
                    foodResult.add(food);
                }
            }

        }
        return foodResult;
    }

    public StorageFilter(String name) {
        super(name);
    }
}
