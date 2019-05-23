package com.vehicles.air;

public class Helicopter extends AirVehicle {

    public Helicopter() {
        putOnMap("Helicopter");
        level = 1;
    }

    @Override
    public void getActivities() {
        super.getActivities();
        System.out.print(" vertic");
    }

    @Override
    public int getCountWings() {
        return 4;
    }
}
