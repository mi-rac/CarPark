package components.carPark;

import components.IDreader.BarcodeReader;
import components.IDreader.RegNumReader;
import components.barrier.Barrier;
import components.sensor.Sensor;
import components.vehicle.Car;
import components.vehicle.Motorcycle;
import components.vehicle.Van;
import main.ParkingCapacity;
import components.patterns.SensorObserver;
import components.patterns.SingletonDecorator;

public class CarPark extends SingletonDecorator<CarPark>
{
    private static final SingletonDecorator<CarPark> singleton = new SingletonDecorator<>();
    ParkingList<Car> carSpaces;
    ParkingList<Motorcycle> motorcycleSpaces;
    ParkingList<Van> vanSpaces;
    Sensor entrySensor;
    Sensor exitSensor;
    RegNumReader entryRegNumReader;
    RegNumReader exitRegNumReader;
    BarcodeReader exitBarcodeReader;
    Barrier entryBarrier;
    Barrier exitBarrier;
    EntryHandler entryHandler;
    ExitHandler exitHandler;

    //private FullSign fullSign;
    //private DataHandler dataHandler;

    private CarPark() {
        carSpaces = new ParkingList<>(ParkingCapacity.getCapacity("car"));
        motorcycleSpaces = new ParkingList<>(ParkingCapacity.getCapacity("motorcycle"));
        vanSpaces = new ParkingList<>(ParkingCapacity.getCapacity("van"));

        entrySensor = new Sensor("entry");
        entryRegNumReader = new RegNumReader();
        entryBarrier = new Barrier();

        exitSensor = new Sensor("exit");
        exitRegNumReader = new RegNumReader();
        exitBarcodeReader = new BarcodeReader();
        exitBarrier = new Barrier();

        entryHandler = new EntryHandler();
        exitHandler = new ExitHandler();

        entrySensor.registerObservers(new SensorObserver[]{entryHandler, entryBarrier});
        exitSensor.registerObservers(new SensorObserver[]{exitHandler, exitBarrier});
    }
    public void entrySensorValue(boolean value) {
        entrySensor.changeSensorState(value);
    }
    public void exitSensorValue(boolean value) {
        exitSensor.changeSensorState(value);
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
