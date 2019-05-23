package com.vehicles.water;

public class Launch extends WaterVehicle {
    public Launch() {
        putOnMap("Launch");
        level = 1;
    }

    @Override
    public void getCountLifeSaver() {
        System.out.println(" savers: 0");
    }
}
