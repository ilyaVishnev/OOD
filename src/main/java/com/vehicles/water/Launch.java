package com.vehicles.water;

public class Launch extends WaterVehicle {
    public Launch() {
        className = "Launch";
        fullNames();
    }

    @Override
    public void getCountLifeSaver() {
        System.out.println(" savers: 0");
    }
}
