package com.vehicles.water;

import com.vehicles.Vehicle;

public abstract class WaterVehicle extends Vehicle {

    public WaterVehicle() {
        putOnMap("WaterVehicle");
    }

    @Override
    public void getActivities() {
        super.getActivities();
        System.out.print(" -> sail");
    }

    public abstract void getCountLifeSaver();
}
