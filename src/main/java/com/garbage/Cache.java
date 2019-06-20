package com.garbage;

import com.google.common.cache.CacheBuilder;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public abstract class Cache {

    public Map<String, SoftReference> objects = new HashMap<>();

    public Load load;

    public Cache() {
    }

    public Cache(Load load) {
        this.load = load;
    }

    public Object getObject(String key) {
        SoftReference result = objects.get(key);
        if (result == null) {
            result = new SoftReference(load.getObject(key));
            objects.put(key, result);
        }
        return result.get();
    }
}
