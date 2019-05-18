package com.market.storages;

public class Warehouse extends Storage {
    @Override
    public boolean accept(int percent) {
        if (percent < 25) {
            return true;
        }
        return false;
    }
}
