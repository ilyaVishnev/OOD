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
    private List<Storage> storages = new ArrayList<>(Arrays.asList(new Storage[]{new Warehouse(), new Shop(), new Trash()}));

    public void putFoodToStorage(Food food) {
        percent = (int) (((double) (toDay.getTimeInMillis() - food.getCreateDate().getTimeInMillis()) / (food.getExpaireDate().getTimeInMillis()
                - food.getCreateDate().getTimeInMillis())) * 100);
        for (Storage storage : storages) {
            if (storage.accept(percent)) {
                food.setDiscount(percent > 75 && percent < 100 ? 13 : 0);
                storage.addFood(food);
                food.setStorage(storage);
                System.out.println(" storage: " + storage + "; " + "food: " + storage.getLastOne().getName() +
                        " ; discount: " + storage.getLastOne().getDiscount());
                break;
            }
        }
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public int getPercent() {
        return percent;
    }
}
