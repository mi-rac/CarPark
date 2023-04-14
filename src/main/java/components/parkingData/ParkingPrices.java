package components.parkingData;

import java.util.HashMap;

public abstract class ParkingPrices
{
    static HashMap<String, Double> hourlyPrices = new HashMap<String, Double>(){static {
        // add prices for cars, motorcycles, and vans
        hourlyPrices.put("car", 2.0);
        hourlyPrices.put("motorcycle", 1.8);
        hourlyPrices.put("van", 2.4);
    }};
    static HashMap<String, Double> dailyPrices = new HashMap<String, Double>(){static {
        // add prices for cars, motorcycles, and vans
        dailyPrices.put("car", 9.89);
        dailyPrices.put("motorcycle", 8.49);
        dailyPrices.put("van", 11.49);
    }};
    abstract void displayPrice();
}
