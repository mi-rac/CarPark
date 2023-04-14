package components.parkingData;

public class CarParkingSession extends ParkingSession
{
    @Override
    protected void endSession(String type) {
        super.endSession("car");
    }
}
