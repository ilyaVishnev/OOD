package com.market.reporting.filters;

import com.market.products.Food;
import com.market.storages.Storage;

import java.util.ArrayList;
import java.util.List;

public class FoodFilter extends Filter {

    @Override
    public List<Food> decant(List<Storage> storages, String parameter) {
        List<Food> foodResult = new ArrayList<>();
        for (Storage storage : storages) {
            for (Food food : storage.getFoods()) {
                if (food.getName().equals(parameter)) {
                    foodResult.add(food);
                }
            }
        }
        return foodResult;
    }

    public FoodFilter(String name) {
        super(name);
    }
}
