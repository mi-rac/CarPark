package components;

public class VanParkingSession extends ParkingSession
{
    public VanParkingSession(String regNum) {
        super(regNum);
    }

    @Override
    protected void endSession(String type) {
        super.endSession("van");
    }
}
