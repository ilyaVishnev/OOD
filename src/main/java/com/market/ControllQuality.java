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

    private List<Storage> storages = new ArrayList<>(Arrays.asList(new Storage[]{new Warehouse(), new Shop(), new Trash()}));

    public void putFoodToStorage(Food food) {
        for (Storage storage : storages) {
            if (storage.accept(food)) {
                System.out.println(" storage: " + storage + "; " + "food: " + storage.getLastOne().getName() +
                        " ; discount: " + storage.getLastOne().getDiscount());
                break;
            }
        }
    }

    public List<Storage> getStorages() {
        return storages;
    }
}
