package components.parkingSession;

public class MotorcycleParkingSession extends ParkingSession
{
    @Override
    public void endSession(String type) {
        super.endSession("motorcycle");
    }
}
