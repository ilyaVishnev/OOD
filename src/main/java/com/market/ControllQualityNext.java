package com.market;

import com.market.products.Food;
import com.market.products.NewFood;
import com.market.products.Pie;
import com.market.storages.Shop;
import com.market.storages.Storage;
import com.market.storages.Warehouse;

import java.util.Calendar;
import java.util.function.Predicate;

public class ControllQualityNext extends ControllQuality {

    private NewFood newFood = new NewFood();

    public ControllQualityNext() {
        Warehouse newWarenHause = new Warehouse();
        Warehouse reproduct = new Warehouse();
        Warehouse lowTemperature = new Warehouse();
        getStorages().add(newWarenHause);
        getStorages().add(reproduct);
        getStorages().add(lowTemperature);
    }

    @Override
    public void putFoodToStorage(Food food) {
        super.putFoodToStorage(food);
        newFood.setFood(food);
        reproduct(newFood);
        getNewWarenhouse(food);
        putVegetableToRifregator(newFood);
    }

    public void getNewWarenhouse(Food food) {
        if (this.getPercent() < 25) {
            getStorages().get(3).addFood(food);
            food.setStorage(getStorages().get(3));
            System.out.println("to New storage: " + getStorages().get(3) + "; " + "food: " + getStorages().get(3).getLastOne().getName() +
                    " ; discount: " + getStorages().get(3).getLastOne().getDiscount());
        }
    }

    public void reproduct(NewFood food) {
        if (food.isCanReproduct() && this.getPercent() > 100) {
            getStorages().get(2).removeLastOne();
            System.out.println("removed from Trash");
            getStorages().get(4).addFood(food);
            System.out.println(" reproductStorage: " + getStorages().get(4) + "; " + "food: " + getStorages().get(4).getLastOne() +
                    " ; discount: " + getStorages().get(4).getLastOne().getDiscount());
        }
    }

    public void putVegetableToRifregator(NewFood food) {
        if (food.isVegetable() && this.getPercent() < 100) {
            getStorages().get(5).addFood(food);
            System.out.println(" refregeratorStorage: " + getStorages().get(5) + "; " + "food: " + getStorages().get(5).getLastOne() +
                    " ; discount: " + getStorages().get(5).getLastOne().getDiscount());
        }
    }

    public NewFood getNewFood() {
        return newFood;
    }

    public void setNewFood(NewFood newFood) {
        this.newFood = newFood;
    }
}
