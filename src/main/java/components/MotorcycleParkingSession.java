package components;

public class MotorcycleParkingSession extends ParkingSession
{
    public MotorcycleParkingSession(String regNum) {
        super(regNum);
    }

    @Override
    protected void endSession(String type) {
        super.endSession("motorcycle");
    }
}
