package components.carPark;

import components.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingList<T extends Vehicle>
{
    private List<T> vehicles;
    private int capacity;

    public ParkingList(int capacity) {
        this.capacity = capacity;
        vehicles = new ArrayList<>();
    }

    public boolean addVehicle(T vehicle) {
        if (vehicles.size() < capacity) {
            vehicles.add(vehicle);
            return true;
        }
        return false;
    }

    public boolean removeVehicle(T vehicle) {
        return vehicles.remove(vehicle);
    }

    public List<T> getVehicles() {
        return vehicles;
    }
}
