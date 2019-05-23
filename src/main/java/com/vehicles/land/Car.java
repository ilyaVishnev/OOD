package com.vehicles.land;

public class Car extends LandVehicle {
    public Car() {
        putOnMap("Car");
        level = 1;
    }

    @Override
    public int getCountWheels() {
        return 4;
    }
}
