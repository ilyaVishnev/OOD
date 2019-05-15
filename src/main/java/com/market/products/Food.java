package com.market.products;

import com.market.storages.Storage;

import java.util.Calendar;
import java.util.Date;

public class Food {

    protected String Name;
    protected Calendar expaireDate;
    protected Calendar createDate;
    protected Integer price;
    protected Integer discount;
    protected Storage storage;

    public Food() {
    }

    public Food(String Name, Calendar expaireDate, Calendar createDate) {
        this.Name = Name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Calendar getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(Calendar expaireDate) {
        this.expaireDate = expaireDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
