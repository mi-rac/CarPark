package components.vehicle;

import components.parkingSession.CarParkingSession;

public class Car extends Vehicle
{
    public Car(String regNum){
        super(regNum, "car", new CarParkingSession());
    }
}
