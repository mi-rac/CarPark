package components.sensor;

import java.util.ArrayList;
import java.util.List;

// Sensor class - represents a sensor that detects the presence of a car
public class Sensor implements SensorState{
    private SensorState state;
    private List<SensorObserver> observers = new ArrayList<>();
    public Sensor() {
        state = new CarNotDetectedState(this);
    }
    public void registerObserver(SensorObserver observer) {
        observers.add(observer);
    }

    public void unregisterObserver(SensorObserver observer) {
        observers.remove(observer);
    }
    // Set the state of the Sensor
    protected void setState(SensorState state) {
        this.state = state;
    }
    // Detect a car
    public void detectVehicle() {
        for (SensorObserver observer : observers) {
            observer.sensorUpdate(true);
        }
        state.detectVehicle();
    }
    // Clear a car from the sensor
    public void clearVehicle() {
        for (SensorObserver observer : observers) {
            observer.sensorUpdate(false);
        }
        state.clearVehicle();
    }
}
