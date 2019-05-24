package com.market;

import com.market.products.Food;
import com.market.products.NewFood;
import com.market.products.Pie;
import com.market.storages.*;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class ControllQualityNext extends ControllQuality {

    private NewFood newFood = new NewFood();
    private ReproductStore reproductStore = new ReproductStore();
    private LowTemperatureStore lowTemperatureStore = new LowTemperatureStore();
    private Warehouse warehouse = new NewWarehouse();

    public ControllQualityNext() {
        reproductStore.setFood(newFood);
        lowTemperatureStore.setFood(newFood);
        getStorages().add(0, reproductStore);
        getStorages().add(1, lowTemperatureStore);
        getStorages().add(2, warehouse);
    }

    @Override
    public void putFoodToStorage(Food food) {
        newFood.setFood(food);
        super.putFoodToStorage(food);
    }

    public NewFood getNewFood() {
        return newFood;
    }

    public void setNewFood(NewFood newFood) {
        this.newFood = newFood;
    }

    public void resort() {
        Iterator<Storage> iterator = getStorages().iterator();
        while (iterator.hasNext()) {
            Storage storage = iterator.next();
            List<Food> foods = storage.getFoods();
            for (int index = 0; index < foods.size(); index++) {
                Food food = foods.get(index);
                if (!storage.accept(food)) {
                    putFoodToStorage(food);
                    foods.remove(food);
                    System.out.println("remove from storage: " + storage + "; " + "food: " + food.getName());
                }
            }
        }
    }
}
