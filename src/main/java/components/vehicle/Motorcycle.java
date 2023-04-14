package components.vehicle;

import components.parkingSession.MotorcycleParkingSession;

public class Motorcycle extends Vehicle
{
    public Motorcycle(String regNum){
        super(regNum, "motorcycle", new MotorcycleParkingSession());
    }
}
