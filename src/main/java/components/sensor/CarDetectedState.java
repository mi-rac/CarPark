package components.sensor;

// CarDetectedState class - represents the state of the Sensor when a car is detected
public class CarDetectedState implements SensorState
{
    private final Sensor sensor;
    public CarDetectedState(Sensor sensor) {
        this.sensor = sensor;
    }
    @Override
    public void detectCar() {
        // Do nothing when car is detected
    }
    @Override
    public void clearCar() {
        // Transition to the CarNotDetectedState when the car is no longer detected
        System.out.println("Car cleared from sensor");
        sensor.setState(new CarNotDetectedState(sensor));
    }
}
