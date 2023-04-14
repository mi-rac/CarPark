package components.sensor;

import patterns.observe.ObservedDecorator;

// Sensor class - represents a sensor that detects the presence of a car
public class Sensor extends ObservedDecorator<SensorObserver> implements SensorState
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
        notifyObservers(true);
    }
    // Clear a car from the sensor
    public void clearVehicle() {
        state.clearVehicle();
        notifyObservers(false);
    }
    @Override
    public void notifyObservers(boolean value) {
        for (SensorObserver observer : super.getObserverList()) {
            observer.sensorUpdate(true);
        }

    }
}
