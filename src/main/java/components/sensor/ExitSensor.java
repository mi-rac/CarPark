package components.sensor;

import components.vehicle.Vehicle;

public class ExitSensor extends Sensor
{
    public void notifyObservers(Vehicle vehicle) {

        for (ExitSensorObserver observer : super.getObserverList()) {
            observer.exitSensorUpdate(vehicle);
        }

    }
}
