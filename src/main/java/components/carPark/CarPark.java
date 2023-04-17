package components.carPark;

import components.barrier.Barrier;
import components.sensor.Sensor;
import components.vehicle.Car;
import components.vehicle.Motorcycle;
import components.vehicle.Van;
import components.vehicle.Vehicle;
import main.ParkingCapacity;
import patterns.SingletonDecorator;

public class CarPark extends SingletonDecorator<CarPark>
{
    private static final SingletonDecorator<CarPark> singleton = new SingletonDecorator<>();
    ParkingManager<Car> carSpaces;
    ParkingManager<Motorcycle> motorcycleSpaces;
    ParkingManager<Van> vanSpaces;
    private Sensor entrySensor;
    private Sensor exitSensor;
    private Barrier entryBarrier;
    private Barrier exitBarrier;
    private EntrySignalHandler entrySignalHandler;
    private ExitSignalHandler exitSignalHandler;

    //private List<IDReader> idReaders;
    //private FullSign fullSign;
    //private DataHandler dataHandler;

    private CarPark() {
        carSpaces = new ParkingManager<>(ParkingCapacity.getCapacity("car"));
        motorcycleSpaces = new ParkingManager<>(ParkingCapacity.getCapacity("motorcycle"));
        vanSpaces = new ParkingManager<>(ParkingCapacity.getCapacity("van"));

        entrySensor = new Sensor();
        exitSensor = new Sensor();

        entryBarrier = new Barrier();
        exitBarrier = new Barrier();

        entrySignalHandler = new EntrySignalHandler();
        exitSignalHandler = new ExitSignalHandler();

        entrySensor.registerObserver(entrySignalHandler);
        entrySensor.registerObserver(entryBarrier);

        exitSensor.registerObserver(exitSignalHandler);
        exitSensor.registerObserver(exitBarrier);
    }

    public void entrySensorVehiclePresent(boolean value) {
        entrySensorVehiclePresent(value, null);
    }
    public void exitSensorClearVehicle(boolean value) {
        entrySensor.changeSensorState(false);
    }
    public void entrySensorVehiclePresent(boolean value, Vehicle vehicle) {
        entrySensor.changeSensorState(value, vehicle);
    }
    public void exitSensorVehiclePresent(boolean value, Vehicle vehicle) {
        exitSensor.changeSensorState(value, vehicle);
    }

    public static CarPark getInstance() {
        return singleton.getInstance(CarPark::new);
    }
}
