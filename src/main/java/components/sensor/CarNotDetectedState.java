package components.sensor;

// CarNotDetectedState class - represents the state of the Sensor when a car is not detected
class CarNotDetectedState implements SensorState
{
    private final Sensor sensor;
    public CarNotDetectedState(Sensor sensor) {
        this.sensor = sensor;
    }
    // Transition to the CarDetectedState when a car is detected
    @Override
    public void detectVehicle(String id) {
        System.out.println("\nCar detected by " + id + " sensor.");
        sensor.setState(new CarDetectedState(sensor));
    }
    @Override
    public void clearVehicle(String id) {
        // Do nothing when car is not detected
    }
}
