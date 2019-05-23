package com.vehicles;

import com.calculator.InteractCalc;
import com.vehicles.air.Airplane;
import com.vehicles.air.Helicopter;
import com.vehicles.land.Bike;
import com.vehicles.land.Bus;
import com.vehicles.land.Car;
import com.vehicles.water.Launch;
import com.vehicles.water.Ship;

import java.util.*;

public class Vehicle {

    public static final Map<Integer, String> levels = new HashMap();
    public static final Map<String, String> names = new HashMap();
    String number = "1.";
    String item = "";
    public Integer level = 1;

    public Vehicle() {
        levels.put(1, Vehicle.class.getSimpleName());
    }

    public void getActivities() {
        System.out.print(" move");
    }

    public void getNames() {
        String root = levels.get(1);
        System.out.println(getLine(root));
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

    public void putOnMap(String className) {
        String key = levels.get(level);
        names.put(key, names.get(key) != null ? (names.get(key).contains(className) ? names.get(key) : names.get(key) + " " + className) : className);
        levels.put(++level, className);
    }

    /**
     * use List of entities to create a menu by initialisation .
     * Put name of entitiy and get its activities.
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Vehicle> vehicles = Arrays.asList(new Ship(), new Airplane(), new Car(), new Bike());
        vehicles.get(0).getNames();

        Scanner scanner = new Scanner(System.in);
        String line;
        while (!(line = scanner.nextLine()).equals("exit")) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getClass().getSimpleName().equals(line)) {
                    vehicle.getActivities();
                    break;
                }
            }
        }
    }
}
