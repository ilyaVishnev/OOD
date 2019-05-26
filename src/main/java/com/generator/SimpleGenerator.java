package com.generator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Template {

    /**
     * it's threadsafe and prevent creation number of entities
     */
    private final Pattern KEYS = Pattern.compile("\\$\\{(.+?)\\}");

    @Override
    public String generate(String text, Map<String, String> map) throws Exception {
        Matcher matcher = KEYS.matcher(text);
        int size = 0;
        while (matcher.find()) {
            String key = matcher.group(1);
            String replaceObj = matcher.group();
            if (map.containsKey(key)) {
                text = text.replaceAll(Pattern.quote(replaceObj), map.get(key));
                size++;
            } else {
                throw new Exception();
            }
        }
        if (!(map.keySet().size() == size)) {
            throw new Exception();
        }
        return text;
    }
}
