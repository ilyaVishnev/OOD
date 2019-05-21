package com.vehicles.air;

import com.vehicles.Vehicle;

public abstract class AirVehicle extends Vehicle {

    public AirVehicle() {
        className = "AirVehicle";
        fullNames();
        highTree++;
    }

    @Override
    public void getActivities() {
        super.getActivities();
        System.out.print(" -> fly");
    }

    public abstract int getCountWings();
}
