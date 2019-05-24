package com.market.products;

import java.util.Calendar;

public class NewFood extends Food {

    private boolean canReproduct = false;
    private Food food;
    private boolean isVegetable = false;

    public NewFood() {
    }

    public NewFood(Food food) {
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public boolean isCanReproduct() {
        return canReproduct;
    }

    public void setCanReproduct(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }

    public boolean isVegetable() {
        return isVegetable;
    }

    public void setVegetable(boolean vegetable) {
        isVegetable = vegetable;
    }

    @Override
    public String toString() {
        return this.food.getName();
    }
}
