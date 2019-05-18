package com.market.storages;

public class Trash extends Storage {
    @Override
    public boolean accept(int percent) {
        if (percent > 100) {
            return true;
        }
        return false;
    }
}
