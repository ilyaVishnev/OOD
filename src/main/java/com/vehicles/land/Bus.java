package com.vehicles.land;

public class Bus extends LandVehicle {
    public Bus() {
        className = "Bus";
        fullNames();
    }

    @Override
    public int getCountWheels() {
        return 6;
    }
}
