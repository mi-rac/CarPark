package components.sensor;

import components.vehicle.Vehicle;
import patterns.Observer;

public interface ExitSensorObserver extends Observer
{
    void exitSensorUpdate(Vehicle vehicle);
}
