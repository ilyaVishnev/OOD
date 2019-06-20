package com.garbage;

import com.google.common.cache.CacheBuilder;
import com.google.common.collect.MapMaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class FileLoad implements Load {

    @Override
    public String getObject(String key) {
        String result = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "\\files\\" + key)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result += line + "\n";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
