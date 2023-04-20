package components.carPark;

import components.IDreader.RegNumReader;
import components.userInterface.UserInterface;
import components.vehicle.Car;
import components.vehicle.Motorcycle;
import components.vehicle.Van;
import components.vehicle.Vehicle;
import components.patterns.SensorObserver;

public class EntryHandler implements SensorObserver
{
    @Override
    public void sensorUpdated(boolean value) {
        CarPark cp = CarPark.getInstance();
        Vehicle vehicle;
        ParkingList parkingList = null;
        RegNumReader reader = cp.entryRegNumReader;

        if (value) {
            String regNum = reader.getID();
            String type = reader.getVehicleType();

            switch (type) {
                case "car" -> {
                    vehicle = new Car(regNum);
                    parkingList = cp.carSpaces;
                }
                case "motorcycle" -> {
                    vehicle = new Motorcycle(regNum);
                    parkingList = cp.motorcycleSpaces;
                }
                case "van" -> {
                    vehicle = new Van(regNum);
                    parkingList = cp.vanSpaces;
                }
                default -> vehicle = new Car(regNum);
            }
            if (parkingList.addVehicle(vehicle)) {
                cp.entryBarrier.open();
                UserInterface.displayMessage("Welcome. Come right through.");
            } else {
                UserInterface.displayMessage("Sorry, no more spaces left");
            }
        }
    }
}

