package components.parkingSession;

public class VanParkingSession extends ParkingSession
{
    @Override
    public void endSession(String type) {
        super.endSession("van");
    }
}
