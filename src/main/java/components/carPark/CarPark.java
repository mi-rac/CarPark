package components.carPark;

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

    //private List<IDReader> idReaders;
    //private FullSign fullSign;
    //private DataHandler dataHandler;

    private CarPark() {
        carSpaces = new ParkingManager<>(ParkingCapacity.getCapacity("car"));
        motorcycleSpaces = new ParkingManager<>(ParkingCapacity.getCapacity("motorcycle"));
        vanSpaces = new ParkingManager<>(ParkingCapacity.getCapacity("van"));

        entranceSensor = new Sensor();
        exitSensor = new Sensor();

        entranceSensor.registerObserver(this);
    }

    @Override
    public void sensorUpdate(boolean vehicleEntering) {
        if (vehicleEntering) {
            ParkingManager pm;
            String regNum = UserInterface.getStringInput("Please enter registration number.");
            String type = UserInterface.multipleChoice("Please enter vehicle type. ", new String[]{"car", "motorcycle", "van"});

            Vehicle vehicle;
            switch (type) {
                case "car" -> {
                    vehicle = new Car(regNum);
                    pm = carSpaces;
                }
                case "motorcycle" -> {
                    vehicle = new Motorcycle(regNum);
                    pm = motorcycleSpaces;
                }
                case "van" -> {
                    vehicle = new Van(regNum);
                    pm = vanSpaces;
                }
            }

            //frontBarrier.raise();

            UserInterface.displayMessage("Welcome. Come right through.");


        }
    }

    public void entranceSensorDetectVehicle() {
        entranceSensor.detectVehicle();
    }

    public static CarPark getInstance() {
        return singleton.getInstance(CarPark::new);
    }
}
