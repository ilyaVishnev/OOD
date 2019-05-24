package com.market.storages;

import com.market.products.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage {

    protected List<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        foods.add(food);
    }

    public abstract boolean accept(Food food);

    public void removeLastOne() {
        foods.remove(foods.size() - 1);
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Food getLastOne() {
        return foods.get(foods.size() - 1);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
