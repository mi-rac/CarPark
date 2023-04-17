package components.carPark;

import components.IDreader.IDreader;
import components.userInterface.UserInterface;
import components.vehicle.Car;
import components.vehicle.Motorcycle;
import components.vehicle.Van;
import components.vehicle.Vehicle;
import patterns.Observer;

public class EntrySignalHandler implements Observer {
    CarPark cp = CarPark.getInstance();
    public void registerChange(boolean value, Vehicle vehicle) {
        ParkingManager parkingManager = null;
        String regNum;
        String type;

        if (value) {
            if (vehicle == null) {
                regNum = IDreader.getRegNum();
                type = IDreader.getVehicleType();

                switch (type) {
                    case "car" -> {
                        vehicle = new Car(regNum);
                        parkingManager = cp.carSpaces;
                    }
                    case "motorcycle" -> {
                        vehicle = new Motorcycle(regNum);
                        parkingManager = cp.motorcycleSpaces;
                    }
                    case "van" -> {
                        vehicle = new Van(regNum);
                        parkingManager = cp.vanSpaces;
                    }
                    default -> vehicle = new Car(regNum);
                }
            }
            if (parkingManager.addVehicle(vehicle)) {
                cp.entryBarrier.open();
                UserInterface.displayMessage("Welcome. Come right through.");
            } else {
                UserInterface.displayMessage("Sorry, no more spaces left");
            }
        } else {



        }
    }
}

