package com.scripts;

import java.util.*;
import java.util.stream.Collectors;

public class Script {

    public static List load(Map<Integer, List> ds, Integer scriptId) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        ((LinkedList<Integer>) queue).addAll(ds.get(scriptId));
        while (!queue.isEmpty()) {
            Integer key = queue.poll();
            result.add(key);
            ((LinkedList<Integer>) queue).addAll(ds.get(key));
        }
        return result.stream().distinct().collect(Collectors.toList());
    }
}
