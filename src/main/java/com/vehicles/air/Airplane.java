package com.vehicles.air;

public class Airplane extends AirVehicle {

    public Airplane() {
        className = "Airplane";
        fullNames();
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
