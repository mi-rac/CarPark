package components.sensor;

import components.vehicle.Vehicle;
import patterns.ObservedDecorator;
import patterns.Observer;

// Sensor class - represents a sensor that detects the presence of a car
public abstract class Sensor<T extends Observer> extends ObservedDecorator<T> implements SensorState
{
    private SensorState state;

    public Sensor() {
        state = new CarNotDetectedState(this);
    }
    // Set the state of the Sensor
    protected void setState(SensorState state) {
        this.state = state;
    }
    // Detect a car
    public void detectVehicle() {
        state.detectVehicle();
    }
    public void detectVehicle(Vehicle vehicle) {
        state.detectVehicle();
        notifyObservers(true);
    }
    // Clear a car from the sensor
    public void clearVehicle() {
        state.clearVehicle();
        notifyObservers(false);
    }
}
