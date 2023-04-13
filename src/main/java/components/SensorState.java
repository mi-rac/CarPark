package components;

// State interface - defines the states that the Sensor can be in
public interface SensorState {
    void detectCar();
    void clearCar();
}
