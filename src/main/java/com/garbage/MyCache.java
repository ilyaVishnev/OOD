package com.garbage;

import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ConcurrentMap;

public class MyCache extends Cache {

    public MyCache(Load load) {
        super(load);
    }

    @Override
    public String getObject(String key) {
        return (String) super.getObject(key);
    }

    public static void main(String[] args) {
        MyCache myCache = new MyCache(new FileLoad());
        System.out.print(myCache.getObject("first.txt"));
        System.out.print(myCache.getObject("first.txt"));
    }
}
