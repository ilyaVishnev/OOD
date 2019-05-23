package com.vehicles.land;

import com.vehicles.Vehicle;

public abstract class LandVehicle extends Vehicle {

    public LandVehicle() {
        putOnMap("LandVehicle");
    }

    @Override
    public void getActivities() {
        super.getActivities();
        System.out.print(" -> drive");
    }

    public abstract int getCountWheels();
}
