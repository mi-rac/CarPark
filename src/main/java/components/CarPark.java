package components;

import java.util.List;

public class CarPark implements CarParkConfig
{
    private static CarPark instance;

    private ParkingManager<Car> cars;
    private ParkingManager<Motorcycle> motorcycles;
    private ParkingManager<Van> vans;

    //private List<IDReader> idReaders;
    //private FullSign fullSign;
    //private DataHandler dataHandler;

    private CarPark() {
        cars = new ParkingManager<>(parkingSpotsNo.get("car"));
        motorcycles = new ParkingManager<>(parkingSpotsNo.get("motorcycle"));
        vans = new ParkingManager<>(parkingSpotsNo.get("van"));
    }

    public static CarPark getInstance() {
        if (instance == null) {
            instance = new CarPark();
        }
        return instance;
    }

}
