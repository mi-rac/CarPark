package components.parkingSession;

public class MotorcycleParkingSession extends ParkingSession
{
    @Override
    protected void endSession(String type) {
        super.endSession("motorcycle");
    }
}
