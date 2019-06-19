package com.garbage;

import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ConcurrentMap;

public abstract class Cache {

    public ConcurrentMap<String, Object> objects = CacheBuilder.newBuilder()
            .softValues()
            .<String, Object>build()
            .asMap();

    public Load load;

    public Cache() {
    }

    public Cache(Load load) {
        this.load = load;
    }

    public Object getObject(String key) {
        Object result = objects.get(key);
        if (result == null) {
            result = load.getObject(key);
            objects.put(key, result);
        }
        return result;
    }
}
