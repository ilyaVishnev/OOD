package com.vehicles.air;

import com.vehicles.Vehicle;

public abstract class AirVehicle extends Vehicle {

    public AirVehicle() {
        putOnMap("AirVehicle");
    }

    @Override
    public void getActivities() {
        super.getActivities();
        System.out.print(" -> fly");
    }

    public abstract int getCountWings();
}
