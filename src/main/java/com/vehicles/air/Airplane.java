package com.vehicles.air;

public class Airplane extends AirVehicle {

    public Airplane() {
        putOnMap("Airplane");
    }

    @Override
    public void getActivities() {
        super.getActivities();
        System.out.print(" horizontal");
    }

    @Override
    public int getCountWings() {
        return 2;
    }
}
