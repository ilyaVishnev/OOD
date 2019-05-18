package com.market.storages;

import com.market.products.Food;
import com.market.products.NewFood;

public class ReproductStore extends Storage {

    protected NewFood food;

    @Override
    public boolean accept(int percent) {
        if (food.isCanReproduct() && percent > 100) {
            return true;
        }
        return false;
    }

    public void setFood(NewFood food) {
        this.food = food;
    }
}
