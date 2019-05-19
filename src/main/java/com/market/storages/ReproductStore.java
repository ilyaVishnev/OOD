package com.market.storages;

import com.market.products.Food;
import com.market.products.NewFood;

public class ReproductStore extends Storage {

    protected NewFood newFood;

    @Override
    public boolean accept(Food food) {
        if (newFood.isCanReproduct() && food.getPercent() > 100) {
            foods.add(newFood);
            return true;
        }
        return false;
    }

    public void setFood(NewFood food) {
        this.newFood = food;
    }
}
