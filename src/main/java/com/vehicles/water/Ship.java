package com.vehicles.water;

public class Ship extends WaterVehicle {
    public Ship() {
        className = "Ship";
        fullNames();
    }

    @Override
    public void getCountLifeSaver() {
        System.out.println(" savers: 4");
    }
}
