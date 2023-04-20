package components.carPark;

import components.userInterface.UserInterface;
import components.vehicle.Vehicle;
import patterns.Observer;

public class ExitHandler implements Observer
{
    @Override
    public void registerChange(boolean value, Vehicle vehicle) {
        CarPark cp = CarPark.getInstance();
        ParkingList parkingList = null;
        if (value) {
            for (ParkingList list : new ParkingList[]{cp.carSpaces, cp.motorcycleSpaces, cp.vanSpaces}) {
                if (list.getVehicles().contains(vehicle)) {
                    parkingList = list;
                }
            }
        vehicle.getSession().endSession(vehicle.getType());
        parkingList.removeVehicle(vehicle);
        cp.exitBarrier.open();
        UserInterface.displayMessage("You can now leave.");
        } else {
            cp.exitBarrier.close();
        }
    }
}
