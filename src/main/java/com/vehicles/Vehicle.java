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

    public static List<String> names = new ArrayList<>(Arrays.asList("Vehicle"));
    public static Integer highTree;
    public static String className;

    public Vehicle() {
        className = "Vehicle";
        highTree = 0;
        fullNames();
        highTree++;
    }

    public void getActivities() {
        System.out.print(" move");
    }

    public void fullNames() {
        if (highTree < names.size()) {
            if (!names.get(highTree).contains(className)) {
                names.set(highTree, names.get(highTree) + " " + className);
            }
        } else {
            names.add(highTree, className);
        }
    }

    public List<String> getNames() {
        int widthTree = names.get(names.size() - 1).length();
        for (int index = 0; index < names.size() - 1; index++) {
            names.set(index, getName(names.get(index), widthTree));
        }
        Collections.reverse(names);
        return names;
    }

    public String getName(String name, int widthTree) {
        int countNames = name.split(" ").length;
        int space = ((widthTree - name.replace(" ", "").length()) / countNames) / 2;
        String part = " ";
        for (int index = 0; index < space; index++) {
            part += " ";
        }
        return part + name.replace(" ", part) + part;
    }

    /**
     * use List of entities to create a tree by initialisation .
     * Put name of entitiy and get its activities.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        List<Vehicle> vehicles = Arrays.asList(new Bike(), new Car(), new Bus(), new Airplane(), new Helicopter());
        vehicles.get(0).getNames().forEach(s -> System.out.println(s));
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
