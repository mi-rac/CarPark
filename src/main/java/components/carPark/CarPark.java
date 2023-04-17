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
    EntryHandler entryHandler;
    ExitHandler exitHandler;

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

        entryHandler = new EntryHandler();
        exitHandler = new ExitHandler();

        entrySensor.registerObserver(entryHandler);
        entrySensor.registerObserver(entryBarrier);

        exitSensor.registerObserver(exitHandler);
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
    public ParkingList getParkingList(String type) {
        switch (type) {
            case "car" -> {return carSpaces;}
            case "motorcycle" -> {return motorcycleSpaces;}
            case "van" -> {return vanSpaces;}
            default -> {return null;}
        }
    }
    public static CarPark getInstance() {
        return singleton.getInstance(CarPark::new);
    }
}
