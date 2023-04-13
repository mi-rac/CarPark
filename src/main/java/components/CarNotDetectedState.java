package components;

// CarNotDetectedState class - represents the state of the Sensor when a car is not detected
class CarNotDetectedState implements SensorState
{
    private final Sensor sensor;
    public CarNotDetectedState(Sensor sensor) {
        this.sensor = sensor;
    }
    // Transition to the CarDetectedState when a car is detected
    @Override
    public void detectCar() {
        System.out.println("Car detected by sensor");
        sensor.setState(new CarDetectedState(sensor));
    }
    @Override
    public void clearCar() {
        // Do nothing when car is not detected
    }
}
