package patterns;

import components.vehicle.Vehicle;

public interface Observer {
    void registerChange(boolean value, Vehicle vehicle);
}
