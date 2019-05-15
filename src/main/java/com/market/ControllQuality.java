package com.market;

import com.market.products.Food;
import com.market.products.Pie;
import com.market.storages.Shop;
import com.market.storages.Storage;
import com.market.storages.Trash;
import com.market.storages.Warehouse;

import java.util.*;
import java.util.function.Predicate;

public class ControllQuality {

    private Calendar toDay = Calendar.getInstance();
    private int percent;
    private int indexActualStorage;
    private List<Storage> storages = new ArrayList<>(Arrays.asList(new Storage[]{new Warehouse(), new Shop(), new Trash()}));

    public void putFoodToStorage(Food food) {
        percent = (int) (((double) (toDay.getTimeInMillis() - food.getCreateDate().getTimeInMillis()) / (food.getExpaireDate().getTimeInMillis()
                - food.getCreateDate().getTimeInMillis())) * 100);
        indexActualStorage = percent > 100 ? 2 : (percent > 75 ? 1 : (percent > 25 ? 1 : 0));
        food.setDiscount(percent > 75 && indexActualStorage == 1 ? 13 : 0);
        storages.get(indexActualStorage).addFood(food);
        food.setStorage(storages.get(indexActualStorage));
        System.out.println(" storage: " + storages.get(indexActualStorage) + "; " + "food: " + storages.get(indexActualStorage).getLastOne().getName() +
                " ; discount: " + storages.get(indexActualStorage).getLastOne().getDiscount());
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public int getPercent() {
        return percent;
    }

    public int getIndexActualStorage() {
        return indexActualStorage;
    }
}
