package com.vehicles.water;

import com.vehicles.Vehicle;

public abstract class WaterVehicle extends Vehicle {

    public WaterVehicle() {
        className = "WaterVehicle";
        fullNames();
        highTree++;
    }

    @Override
    public void getActivities() {
        super.getActivities();
        System.out.print(" -> sail");
    }

    public abstract void getCountLifeSaver();
}
