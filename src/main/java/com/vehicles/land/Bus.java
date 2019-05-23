package com.vehicles.land;

public class Bus extends LandVehicle {
    public Bus() {
        putOnMap("Bus");
        level = 1;
    }

    @Override
    public int getCountWheels() {
        return 6;
    }
}
