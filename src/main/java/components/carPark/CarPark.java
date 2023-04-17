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

    ParkingList<Car> carSpaces;
    ParkingList<Motorcycle> motorcycleSpaces;
    ParkingList<Van> vanSpaces;
    Sensor entrySensor;
    Sensor exitSensor;
    Barrier entryBarrier;
    Barrier exitBarrier;
    EntryHandler entrySignalHandler;
    ExitHandler exitSignalHandler;

    //private List<IDReader> idReaders;
    //private FullSign fullSign;
    //private DataHandler dataHandler;

    private CarPark() {
        carSpaces = new ParkingList<>(ParkingCapacity.getCapacity("car"));
        motorcycleSpaces = new ParkingList<>(ParkingCapacity.getCapacity("motorcycle"));
        vanSpaces = new ParkingList<>(ParkingCapacity.getCapacity("van"));

        entrySensor = new Sensor();
        exitSensor = new Sensor();

        entryBarrier = new Barrier();
        exitBarrier = new Barrier();

        entrySignalHandler = new EntryHandler();
        exitSignalHandler = new ExitHandler();

        entrySensor.registerObserver(entrySignalHandler);
        entrySensor.registerObserver(entryBarrier);

        exitSensor.registerObserver(exitSignalHandler);
        exitSensor.registerObserver(exitBarrier);
    }

    public void entrySensorValue(boolean value) {
        entrySensorValue(value, null);
    }
    public void exitSensorValue(boolean value) {
        exitSensorValue(value, null);
    }
    public void entrySensorValue(boolean value, Vehicle vehicle) {
        entrySensor.changeSensorState(value, vehicle);
    }
    public void exitSensorValue(boolean value, Vehicle vehicle) {
        exitSensor.changeSensorState(value, vehicle);
    }

    public static CarPark getInstance() {
        return singleton.getInstance(CarPark::new);
    }
}
