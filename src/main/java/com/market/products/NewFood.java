package com.market.products;

import java.util.Calendar;

public class NewFood extends Food {

    private boolean canReproduct = false;
    private Food food;
    private boolean isVegetable = false;

    public NewFood() {
    }

    @Override
    public Integer getDiscount() {
        return food.getDiscount();
    }

    @Override
    public String getName() {
        return food.getName();
    }

    public NewFood(boolean isVegetable) {
        this.isVegetable = isVegetable;
    }

    public NewFood(Food food) {
        this.food = food;
    }

    public NewFood(String Name, Calendar expaireDate, Calendar createDate) {
        super(Name, expaireDate, createDate);
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
