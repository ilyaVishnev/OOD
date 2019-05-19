package com.market.storages;

import com.market.products.Food;

public class Warehouse extends Storage {
    @Override
    public boolean accept(Food food) {
        if (food.getPercent() < 25) {
            foods.add(food);
            return true;
        }
        return false;
    }
}
