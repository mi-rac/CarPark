package components.carPark;

import components.barrier.Barrier;
import components.sensor.*;
import components.userInterface.UserInterface;
import components.vehicle.Car;
import components.vehicle.Motorcycle;
import components.vehicle.Van;
import components.vehicle.Vehicle;
import main.ParkingCapacity;
import patterns.SingletonDecorator;

public class CarPark extends SingletonDecorator<CarPark> implements EntranceSensorObserver, ExitSensorObserver
{
    private static final SingletonDecorator<CarPark> singleton = new SingletonDecorator<>();
    private ParkingManager<Car> carSpaces;
    private ParkingManager<Motorcycle> motorcycleSpaces;
    private ParkingManager<Van> vanSpaces;
    private Sensor entranceSensor;
    private Sensor exitSensor;
    private Barrier entranceBarrier;
    private Barrier exitBarrier;

    //private List<IDReader> idReaders;
    //private FullSign fullSign;
    //private DataHandler dataHandler;

    private CarPark() {
        carSpaces = new ParkingManager<>(ParkingCapacity.getCapacity("car"));
        motorcycleSpaces = new ParkingManager<>(ParkingCapacity.getCapacity("motorcycle"));
        vanSpaces = new ParkingManager<>(ParkingCapacity.getCapacity("van"));

        entranceSensor = new EntraceSensor();
        exitSensor = new ExitSensor();

        entranceBarrier = new Barrier();
        exitBarrier = new Barrier();

        entranceSensor.registerObserver(this);
        entranceSensor.registerObserver(entranceBarrier);

        exitSensor.registerObserver(this);
        exitSensor.registerObserver(exitBarrier);
    }

    @Override
    public void entranceSensorUpdate(boolean vehiclePresent) {
        ParkingManager parkingManager = null;
        Vehicle vehicle;
        String regNum;
        String type;

        if (vehiclePresent) {
            regNum = UserInterface.getStringInput("Please enter registration number.");
            type = UserInterface.multipleChoice("Please enter vehicle type. ", new String[]{"car", "motorcycle", "van"});

            switch (type) {
                case "car" -> {
                    vehicle = new Car(regNum);
                    parkingManager = carSpaces;
                }
                case "motorcycle" -> {
                    vehicle = new Motorcycle(regNum);
                    parkingManager = motorcycleSpaces;
                }
                case "van" -> {
                    vehicle = new Van(regNum);
                    parkingManager = vanSpaces;
                }
                default -> vehicle = new Car(regNum);
            }
            if (parkingManager.addVehicle(vehicle)) {
                entranceBarrier.open();
                UserInterface.displayMessage("Welcome. Come right through.");
            } else {
                UserInterface.displayMessage("Sorry, no more spaces left");
            }
        }
    }

    @Override
    public void exitSensorUpdate(Vehicle vehicle) {
        ParkingManager parkingManager = null;
        for (ParkingManager<?> pm : new ParkingManager[]{carSpaces, motorcycleSpaces, vanSpaces}) {
            if (pm.getVehicles().contains(vehicle)) {
                parkingManager = pm;
            }
        }
        vehicle.getSession().endSession(vehicle.getType());
        parkingManager.removeVehicle(vehicle);
    }

    public void entranceSensorDetectVehicle() {
        entranceSensor.detectVehicle();
    }

    public void entranceSensorClearVehicle() {
        entranceSensor.clearVehicle();
    }

    public void exitSensorDetectVehicle(Vehicle vehicle) {
        exitSensor.detectVehicle();
    }

    public void exitSensorClearVehicle() {
        exitSensor.clearVehicle();
    }

    public static CarPark getInstance() {
        return singleton.getInstance(CarPark::new);
    }
}
