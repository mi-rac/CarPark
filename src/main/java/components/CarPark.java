package components;

import java.util.List;

public class CarPark implements CarParkConfig
{
    private static CarPark instance;

    private List<CarParkingSession> cars;
    private List<MotorcycleParkingSession> motorcycles;
    private List<VanParkingSession> vans;

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
