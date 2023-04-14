package components.parkingSession;

public class CarParkingSession extends ParkingSession
{
    @Override
    public void endSession(String type) {
        super.endSession("car");
    }
}
