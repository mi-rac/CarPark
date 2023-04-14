package components.parkingData;

public class VanParkingSession extends ParkingSession
{
    @Override
    protected void endSession(String type) {
        super.endSession("van");
    }
}
