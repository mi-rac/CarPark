package components.sensor;

import components.vehicle.Vehicle;
import patterns.ObservedDecorator;
import patterns.Observer;

// Sensor class - represents a sensor that detects the presence of a car
public class Sensor<T extends Observer> extends ObservedDecorator<T>
{
    private SensorState state;

    public Sensor() {
        state = new CarNotDetectedState(this);
    }
    // Set the state of the Sensor
    protected void setState(SensorState state) {
        this.state = state;
    }
    public void changeSensorState(boolean sensing) {
        changeSensorState(sensing, null);
    }
    // Detect a car
    public void changeSensorState(boolean sensing, Vehicle vehicle) {
        state.detectVehicle();
        notifyObservers(sensing, vehicle);
    }
}
