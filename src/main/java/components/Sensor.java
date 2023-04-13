package components;

// Sensor class - represents a sensor that detects the presence of a car
public class Sensor {
    private SensorState state;
    public Sensor() {
        this.state = new CarNotDetectedState(this);
    }
    // Set the state of the Sensor
    public void setState(SensorState state) {
        this.state = state;
    }
    // Check if a car is present
    public boolean isCarPresent() {
        // Let the current state handle the car detection logic
        return state instanceof CarDetectedState;
    }
    // Detect a car
    public void detectCar() {
        state.detectCar();
    }
    // Clear a car from the sensor
    public void clearCar() {
        state.clearCar();
    }
}
