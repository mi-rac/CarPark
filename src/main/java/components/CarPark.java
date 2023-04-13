package components;

public class CarPark
{
    private static CarPark instance;
    private int occupiedSpots;
    private int maxCapacity;
    //private List<Sensor> sensors;
    //private List<IDReader> idReaders;
    //private FullSign fullSign;
    //private DataHandler dataHandler;

    private CarPark() {}

    public static CarPark getInstance() {
        if (instance == null) {
            instance = new CarPark();
        }
        return instance;
    }
}
