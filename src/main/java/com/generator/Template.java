package com.generator;

import java.util.Map;

public interface Template {

    public String generate(String text, Map<String, String> map) throws Exception;
}
