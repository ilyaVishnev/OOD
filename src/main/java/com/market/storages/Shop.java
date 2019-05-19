package com.market.storages;

import com.market.products.Food;

public class Shop extends Storage {

    public boolean accept(Food food) {
        if (food.getPercent() < 100 && food.getPercent() > 25) {
            food.setDiscount(food.getPercent() > 75 && food.getPercent() < 100 ? 13 : 0);
            foods.add(food);
            return true;
        }
        return false;
    }
}
