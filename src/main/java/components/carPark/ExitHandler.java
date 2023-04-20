package components.carPark;

import components.userInterface.UserInterface;
import components.vehicle.Vehicle;
import patterns.SensorObserver;

import java.util.List;

public class ExitHandler implements SensorObserver
{
    Vehicle vehicle;
    private ParkingList parkingList = null;

    @Override
    public void sensorUpdated(boolean value) {
        CarPark cp = CarPark.getInstance();
        String readerType = UserInterface.multipleChoice("What are we scanning today?", new String[]{"regNum", "barcode"});
        handleExit(readerType);
        vehicle.getSession().endSession(vehicle.getType());
        parkingList.removeVehicle(vehicle);
        cp.exitBarrier.open();
        UserInterface.displayMessage("You can now leave.");
    }

    private boolean handleExit(String readerType) {
        CarPark cp = CarPark.getInstance();
        String id = readerType.equals("regNum") ? cp.exitRegNumReader.getID() : cp.exitBarcodeReader.getID();
        for (ParkingList list : new ParkingList[]{cp.carSpaces, cp.motorcycleSpaces, cp.vanSpaces}) {
            for (Vehicle v : (List<Vehicle>) list.getVehicles()) {
                if (id.equals(readerType.equals("regNum") ? v.getRegNum() : v.getSession().getBarcode())) {
                    parkingList = list;
                    vehicle = v;
                    return true;
                }
            }
        }
        UserInterface.displayMessage("Invalid ID");
        return false;
    }
}