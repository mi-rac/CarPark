package components.sensor;

import components.patterns.ObservedDecorator;
import components.patterns.SensorObserver;
import java.util.List;

// Sensor class - represents a sensor that detects the presence of a car
public class Sensor extends ObservedDecorator
{
    private SensorState state;
    String id;

    public Sensor(String id) {
        state = new CarNotDetectedState(this);
        this.id = id;
    }
    // Set the state of the Sensor
    protected void setState(SensorState state) {
        this.state = state;
    }
    public void changeSensorState(boolean value) {
        if (value) {
            state.detectVehicle(id);
        } else {
            state.clearVehicle(id);
        }
        notifyObservers(value);
    }
    public void notifyObservers(boolean value) {
        for (SensorObserver observer : (List<SensorObserver>) getObserverList()) {
            observer.sensorUpdated(value);
        }
    }
}
