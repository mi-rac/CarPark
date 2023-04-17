package components.carPark;

import components.userInterface.UserInterface;
import components.vehicle.Car;
import components.vehicle.Motorcycle;
import components.vehicle.Van;
import components.vehicle.Vehicle;
import patterns.Observer;

public class EntrySignalHandler implements Observer
{
    CarPark cp = CarPark.getInstance();
    @Override
    public void registerChange(boolean value, Vehicle vehicle) {
        ParkingManager parkingManager = null;
        String regNum;
        String type;
        if (value && vehicle == null) {
            regNum = UserInterface.getStringInput("Please enter registration number.");
            type = UserInterface.multipleChoice("Please enter vehicle type. ", new String[]{"car", "motorcycle", "van"});

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
            if (parkingManager.addVehicle(vehicle)) {
                CarPark.getInstance().entryBarrier.open();
                UserInterface.displayMessage("Welcome. Come right through.");
            } else {
                UserInterface.displayMessage("Sorry, no more spaces left");
            }
        }
        }
    }
}
