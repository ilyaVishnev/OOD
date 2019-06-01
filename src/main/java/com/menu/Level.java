package com.menu;

import java.util.*;

public class Level {

    public static final Map<String, String> names = new HashMap();
    String number = "1.";
    String item = "";
    public String root;
    public String topic;

    public Level(String topic, String root) {
        this.root = root;
        this.topic = topic;
        putOnMap(topic, root);
    }

    public String getTopic() {
        return topic;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public void getActivities() {
        System.out.print(" activities from " + topic);
    }

    public void getNames() {
        System.out.println(getLine(this.root));
    }

    public String getLine(String root) {
        item += number + root + "\n";
        if (names.get(root) == null) {
            return "\n";
        }
        String[] items = names.get(root).split(" ");
        for (int index = 0; index < items.length; index++) {
            number = number + (index + 1) + ".";
            getLine(items[index]);
            number = number.substring(0, number.indexOf(".", number.length() - 3) + 1);
        }
        return item;
    }

    public void putOnMap(String className, String root) {
        names.put(root, names.get(root) != null ? (names.get(root).contains(className) ? names.get(root) : names.get(root) +
                " " + className) : className);
    }

    /**
     * use List of entities to create a menu by initialisation .
     * Put name of topic and its subtopic in constructor.
     *
     * @param args
     */

    public static void main(String[] args) {
        List<Level> menu = Arrays.asList(new Level("firstLevel", "start"), new Level("firstLevel1", "start"), new Level("secondLevel", "firstLevel"), new Level("secondLevel1", "firstLevel"),
                new Level("secondLevel3", "firstLevel1"), new Level("secondLevel4", "firstLevel1"),
                new Level("secondLevel5", "firstLevel1"));
        menu.get(0).getNames();

        Scanner scanner = new Scanner(System.in);
        String line;
        while (!(line = scanner.nextLine()).equals("exit")) {
            for (Level level : menu) {
                if (level.getTopic().equals(line)) {
                    level.getActivities();
                    break;
                }
            }
        }
    }
}
