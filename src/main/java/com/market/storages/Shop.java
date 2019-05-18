package com.market.storages;

public class Shop extends Storage {

    public boolean accept(int percent) {
        if (percent < 100 && percent > 25) {
            return true;
        }
        return false;
    }
}
