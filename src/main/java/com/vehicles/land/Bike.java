package com.vehicles.land;

public class Bike extends LandVehicle {

    public Bike() {
        putOnMap("Bike");
        level = 1;
    }

    @Override
    public int getCountWheels() {
        return 2;
    }
}
