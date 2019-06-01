package com.market.reporting;

import com.market.products.Food;
import com.market.storages.Storage;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class GenerateReport {

    public void report(String filter, List<Storage> storages) {
        String[] filters = filter.split(" ");
        List<Food> foods = new ArrayList<>();
        String name = filters[0];
        for (String f : filters) {
            switch (f) {
                case "-food":
                    foods = getResultByFoodName(name, storages);
                    break;
                case "-storage":
                    foods = getResultByStorageName(name, storages);
                    break;
                case "-all":
                    foods = getAll(storages);
                    break;
                case "-file":
                    writeFile(foods);
                    break;
                case "-console":
                    writeOnConsole(foods);
                    break;
            }
        }
    }

    public List<Food> getAll(List<Storage> storages) {
        List<Food> foodResult = new ArrayList<>();
        for (Storage storage : storages) {
            for (Food food : storage.getFoods()) {
                foodResult.add(food);
            }
        }
        return foodResult;
    }

    public List<Food> getResultByFoodName(String foodName, List<Storage> storages) {
        List<Food> foodResult = new ArrayList<>();
        for (Storage storage : storages) {
            for (Food food : storage.getFoods()) {
                if (food.getName().equals(foodName)) {
                    foodResult.add(food);
                }
            }
        }
        return foodResult;
    }

    public List<Food> getResultByStorageName(String storageName, List<Storage> storages) {
        List<Food> foodResult = new ArrayList<>();
        for (Storage storage : storages) {
            if (storage.getClass().getSimpleName().equals(storageName)) {
                for (Food food : storage.getFoods()) {
                    foodResult.add(food);
                }
            }

        }
        return foodResult;
    }

    public void writeFile(List<Food> foods) {
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream("myList.txt"), true)) {
            for (Food food : foods) {
                printWriter.println(food.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void writeOnConsole(List<Food> foods) {
        for (Food food : foods) {
            System.out.println(food.getName());
        }
    }
}
