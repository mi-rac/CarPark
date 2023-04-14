package components;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class ParkingSession implements ParkingPrices
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
    protected void endSession(String type){
        end = LocalDateTime.now();
        priceRate = setPriceRate(type);
        price = duration * priceRate;
    }
    protected int calculateDifferenceInHours(){
        Duration timeInterval = Duration.between(start, end);
        long differenceInHours = timeInterval.toHours();
        return (int) differenceInHours;
    }
    protected double setPriceRate(String type){
        duration = calculateDifferenceInHours();
        if (duration > 23) {
            duration = duration % 24;
            return dailyPrices.get(type);
        } else {
            return hourlyPrices.get(type);
        }
    }
    public void displayPrice() {
        if (end != null) System.out.println("Total price for the parking session: " + price);
        else System.out.println("Session is not over yet.");
    }
}
