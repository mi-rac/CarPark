package components.sensor;

import patterns.ObservedDecorator;
import patterns.SensorObserver;
import java.util.List;

// Sensor class - represents a sensor that detects the presence of a car
public class Sensor extends ObservedDecorator
{
    private SensorState state;

    public Sensor() {
        state = new CarNotDetectedState(this);
    }
    // Set the state of the Sensor
    protected void setState(SensorState state) {
        this.state = state;
    }
    public void changeSensorState(boolean value) {
        if (value) {
            state.detectVehicle();
        } else {
            state.clearVehicle();
        }
        notifyObservers(value);
    }
    public void notifyObservers(boolean value) {
        for (SensorObserver observer : (List<SensorObserver>) getObserverList()) {
            observer.sensorUpdated(value);
        }
    }
}
