package components.carPark;

import components.parkingSession.CarParkingSession;
import components.parkingSession.MotorcycleParkingSession;
import components.parkingSession.ParkingSession;
import components.parkingSession.VanParkingSession;
import components.sensor.Sensor;
import components.sensor.SensorObserver;
import components.userInterface.UserInterface;
import components.vehicle.Car;
import components.vehicle.Motorcycle;
import components.vehicle.Van;
import components.vehicle.Vehicle;
import config.ParkingCapacity;
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
            String regNum = UserInterface.getStringInput("Please enter registration number.");
            String type;
            do {
                type = UserInterface.getStringInput("Please enter vehicle type. (car, motorcycle, van");
            }
            while (UserInterface.validateMultipleChoice(type, new String[]{"car", "motorcycle", "van"}));

            Vehicle vehicle;
            switch (type) {
                case "car" -> vehicle = new Car(regNum);
                case "motorcycle" -> vehicle = new Motorcycle(regNum);
                case "van" -> vehicle = new Van(regNum);
            }
            //vehicle.park();
        }
    }

    public void entranceSensorDetectVehicle() {
        entranceSensor.detectVehicle();
    }

    public static CarPark getInstance() {
        return singleton.getInstance(CarPark::new);
    }
}
