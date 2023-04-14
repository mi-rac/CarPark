package main;

import components.carPark.CarPark;

public class CarParkSimulation {

    public static void main(String[] args) {
        // Create the car park
        CarPark cp = CarPark.getInstance();
        cp.entranceSensorDetectVehicle();

    }
}
