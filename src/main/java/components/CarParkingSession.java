package components;

public class CarParkingSession extends ParkingSession
{
    public CarParkingSession(String regNum) {
        super(regNum);
    }

    @Override
    protected void endSession(String type) {
        super.endSession("car");
    }
}
