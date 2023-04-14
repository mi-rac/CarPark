package components.vehicle;

import components.parkingSession.VanParkingSession;

public class Van extends Vehicle
{
    public Van(String regNum){
        super(regNum, "van", new VanParkingSession());
    }
}
