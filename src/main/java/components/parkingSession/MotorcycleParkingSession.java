package components.parkingSession;

public class MotorcycleParkingSession extends ParkingSession
{
    public void endSession() {
        super.endSession("motorcycle");
    }
}
