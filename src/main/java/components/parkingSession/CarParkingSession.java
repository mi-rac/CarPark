package components.parkingSession;

public class CarParkingSession extends ParkingSession
{
    public void endSession() {
        super.endSession("car");
    }
}
