package components;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager<T extends Vehicle>
{
    private List<T> vehicles;
    private int capacity;
    private int availability;
    public ParkingManager(int capacity) {
        this.capacity = capacity;
        availability = capacity;
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
