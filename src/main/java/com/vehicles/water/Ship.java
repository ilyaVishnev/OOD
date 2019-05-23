package com.vehicles.water;

public class Ship extends WaterVehicle {
    public Ship() {
        putOnMap("Ship");
        level = 1;
    }

    @Override
    public void getCountLifeSaver() {
        System.out.println(" savers: 4");
    }
}
