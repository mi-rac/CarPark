package main;

import components.carPark.CarPark;
import components.vehicle.Vehicle;

public class CarParkSimulation {

    public static void main(String[] args) throws InterruptedException {
        // Create the car park
        CarPark cp = CarPark.getInstance();

        for (int i = 0; i < 3; i++) {
            cp.entrySensorValue(true);
            Thread.sleep(500);
            cp.entrySensorValue(false);
            Thread.sleep(1000);
        }

        Vehicle myCar = (Vehicle) cp.getParkingList("car").getVehicles().get(0);

        cp.exitSensorValue(true, myCar);
        cp.exitSensorValue(false);
    }
}
