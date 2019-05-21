package com.vehicles.land;

public class Car extends LandVehicle {
    public Car() {
        className = "Car";
        fullNames();
    }

    @Override
    public int getCountWheels() {
        return 4;
    }
}
