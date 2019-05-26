package com.generator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TemplateTest {

    @Test
    public void whenPutPatternGetGenerateValue() {
        Template generator = new SimpleGenerator();
        String text = "What ${subject} wonna do - ${action}";
        String genText = null;
        Map<String, String> map = new HashMap<>();
        map.put("subject", "i");
        map.put("action", "nothing");
        try {
            genText = generator.generate(text, map);
        } catch (Exception ex) {
        }
        assertEquals(genText, "What i wonna do - nothing");
    }

    @Test
    public void whenPutWrongKeysGetException() {
        Template generator = new SimpleGenerator();
        String exception = "";
        String text = "What ${subject} wonna do - ${action}";
        Map<String, String> map = new HashMap<>();
        map.put("object", "i");
        map.put("action", "nothing");
        try {
            generator.generate(text, map);
        } catch (Exception ex) {
            exception = "exception happend";
        }
        assertEquals(exception, "exception happend");
    }

    @Test
    public void whenMapHasMoreKeysGetException() {
        Template generator = new SimpleGenerator();
        String exception = "";
        String text = "What ${subject} wonna do - ${action}";
        Map<String, String> map = new HashMap<>();
        map.put("subject", "i");
        map.put("action", "nothing");
        map.put("excessive key", "value");
        try {
            generator.generate(text, map);
        } catch (Exception ex) {
            exception = "exception happend";
        }
        assertEquals(exception, "exception happend");
    }

}