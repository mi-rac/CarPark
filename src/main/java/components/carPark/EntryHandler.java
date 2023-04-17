package components.carPark;

import components.IDreader.IDreader;
import components.userInterface.UserInterface;
import components.vehicle.Car;
import components.vehicle.Motorcycle;
import components.vehicle.Van;
import components.vehicle.Vehicle;
import patterns.Observer;

public class EntryHandler implements Observer {
    public void registerChange(boolean value, Vehicle vehicle) {
        CarPark cp = CarPark.getInstance();
        ParkingList parkingList = null;
        String regNum;
        String type;

        if (value) {
            if (vehicle == null) {
                regNum = IDreader.getRegNum();
                type = IDreader.getVehicleType();

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
            }
            if (parkingList.addVehicle(vehicle)) {
                cp.entryBarrier.open();
                UserInterface.displayMessage("Welcome. Come right through.");
            } else {
                UserInterface.displayMessage("Sorry, no more spaces left");
            }
        } else {
            cp.entryBarrier.close();
        }
    }
}

