package components;

import java.util.HashMap;

public interface ParkingPrices
{
    HashMap<String, double> hourlyPrices = new HashMap<String, double>(){static {
        // add prices for cars, motorcycles, and vans
        hourlyPrices.put("car", 2.0);
        hourlyPrices.put("motorcycle", 1.8);
        hourlyPrices.put("van", 2.4);
    }};
    HashMap<String, double> dailyPrices = new HashMap<String, double>(){static {
        // add prices for cars, motorcycles, and vans
        dailyPrices.put("car", 9.89);
        dailyPrices.put("motorcycle", 8.49);
        dailyPrices.put("van", 11.49);
    }};
    void displayPrice();
}
