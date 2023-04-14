package components;

public class CarPark extends SingletonDecorator<CarPark> implements CarParkConfig
{
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
}
