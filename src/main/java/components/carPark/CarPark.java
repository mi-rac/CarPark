package components.carPark;

import components.vehicle.Car;
import components.vehicle.Motorcycle;
import components.vehicle.Van;
import config.ParkingCapacity;
import patterns.SingletonDecorator;

public class CarPark extends SingletonDecorator<CarPark>
{
    private static final SingletonDecorator<CarPark> singleton = new SingletonDecorator<>();
    private ParkingManager<Car> cars;
    private ParkingManager<Motorcycle> motorcycles;
    private ParkingManager<Van> vans;

    //private List<IDReader> idReaders;
    //private FullSign fullSign;
    //private DataHandler dataHandler;

    private CarPark() {
        cars = new ParkingManager<>(ParkingCapacity.getCapacity("car"));
        motorcycles = new ParkingManager<>(ParkingCapacity.getCapacity("motorcycle"));
        vans = new ParkingManager<>(ParkingCapacity.getCapacity("van"));
    }

    public static CarPark getInstance() {
        return singleton.getInstance(CarPark::new);
    }
}
