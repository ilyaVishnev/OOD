package com.market.storages;

import com.market.products.NewFood;

public class LowTemperatureStore extends Storage {

    protected NewFood food;

    @Override
    public boolean accept(int percent) {
        if (food.isVegetable() && percent < 100) {
            return true;
        }
        return false;
    }

    public void setFood(NewFood food) {
        this.food = food;
    }
}
