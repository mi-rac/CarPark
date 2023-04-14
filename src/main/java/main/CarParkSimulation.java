package main;

import components.CarPark;

public class CarParkSimulation {
    private static CarPark cp;

    public static void main(String[] args) {
        // Create the car park
        cp = CarPark.getInstance();

        cp.getSensorEntrance();
    }
}
