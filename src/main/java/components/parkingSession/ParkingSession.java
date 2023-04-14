package components.parkingSession;

import main.ParkingPrices;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class ParkingSession
{
    protected LocalDateTime start;
    protected LocalDateTime end;
    protected int duration;
    protected double priceRate;
    protected double price;
    protected ParkingSession(){
        startSession();
    }
    // Concrete methods for recording the start and end time of the session.
    protected void startSession(){
        start = LocalDateTime.now();
    }
    public void endSession(String type){
        end = LocalDateTime.now();
        priceRate = setPriceRate(type);
        price = duration * priceRate;
        displayPrice();
    }
    protected int calculateDifferenceInHours(){
        Duration timeInterval = Duration.between(start, end);
        long differenceInHours = timeInterval.toSeconds();
        return (int) differenceInHours;
    }
    protected double setPriceRate(String type){
        duration = calculateDifferenceInHours();
        if (duration > 23) {
            duration = duration % 24;
            return ParkingPrices.getRate(type, "day");
        } else {
            return ParkingPrices.getRate(type, "hour");
        }
    }
    public void displayPrice() {
        if (end != null) System.out.println("Total price for the parking session: " + price);
        else System.out.println("Session is not over yet.");
    }
}
