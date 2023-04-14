package components.carPark;

import components.barrier.Barrier;
import components.sensor.Sensor;
import components.sensor.SensorObserver;
import components.userInterface.UserInterface;
import components.vehicle.Car;
import components.vehicle.Motorcycle;
import components.vehicle.Van;
import components.vehicle.Vehicle;
import main.ParkingCapacity;
import patterns.SingletonDecorator;

public class CarPark extends SingletonDecorator<CarPark> implements SensorObserver
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

        entranceSensor = new Sensor();
        exitSensor = new Sensor();

        entranceBarrier = new Barrier();
        exitBarrier = new Barrier();

        entranceSensor.registerObserver(this);
        entranceSensor.registerObserver(entranceBarrier);
    }

    @Override
    public void sensorUpdate(boolean vehiclePresent) {
        ParkingManager parkingManager = null;
        Vehicle vehicle = null;
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

    public void entranceSensorDetectVehicle() {
        entranceSensor.detectVehicle();
    }

    public void entranceSensorClearVehicle() {
        entranceSensor.clearVehicle();
    }

    public static CarPark getInstance() {
        return singleton.getInstance(CarPark::new);
    }
}
