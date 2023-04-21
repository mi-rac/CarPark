package components.parkingSession;

public class VanParkingSession extends ParkingSession
{
    public void endSession() {
        super.endSession("van");
    }
}
