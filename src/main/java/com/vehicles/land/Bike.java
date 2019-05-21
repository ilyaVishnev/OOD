package com.vehicles.land;

public class Bike extends LandVehicle {

    public Bike() {
        className = "Bike";
        fullNames();
    }

    @Override
    public int getCountWheels() {
        return 2;
    }
}
