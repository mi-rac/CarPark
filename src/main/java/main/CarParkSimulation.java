package main;

import components.carPark.CarPark;

public class CarParkSimulation {

    public static void main(String[] args) throws InterruptedException {
        // Create the car park
        CarPark cp = CarPark.getInstance();
        cp.entrySensorDetectVehicle();
        Thread.sleep(1000);
        cp.entrySensorClearVehicle();

        cp.entrySensorDetectVehicle();
        Thread.sleep(1000);
        cp.entrySensorClearVehicle();

        cp.entrySensorDetectVehicle();
        Thread.sleep(1000);
        cp.entrySensorClearVehicle();
    }
}
