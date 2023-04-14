package components.sensor;

// Sensor class - represents a sensor that detects the presence of a car
public class Sensor {
    private SensorState state;
    protected Sensor() {
        state = new CarNotDetectedState(this);
    }
    // Set the state of the Sensor
    protected void setState(SensorState state) {
        this.state = state;
    }
    // Check if a car is present
    protected boolean isCarPresent() {
        // Let the current state handle the car detection logic
        return state instanceof CarDetectedState;
    }
    // Detect a car
    protected void detectCar() {
        state.detectCar();
    }
    // Clear a car from the sensor
    protected void clearCar() {
        state.clearCar();
    }
}
