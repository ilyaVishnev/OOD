package com.market.storages;

import com.market.products.Food;

public class Trash extends Storage {
    @Override
    public boolean accept(Food food) {
        if (food.getPercent() > 100) {
            foods.add(food);
            return true;
        }
        return false;
    }
}
