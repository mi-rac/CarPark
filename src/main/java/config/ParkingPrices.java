package config;

import java.util.HashMap;
import java.util.Map;

public class ParkingPrices
{
    private static final Map<String, Double> hourlyPrices = new HashMap<String, Double>(){static {
        // add prices for cars, motorcycles, and vans
        hourlyPrices.put("car", 2.0);
        hourlyPrices.put("motorcycle", 1.8);
        hourlyPrices.put("van", 2.4);
    }};
    private static final Map<String, Double> dailyPrices = new HashMap<String, Double>(){static {
        // add prices for cars, motorcycles, and vans
        dailyPrices.put("car", 9.89);
        dailyPrices.put("motorcycle", 8.49);
        dailyPrices.put("van", 11.49);
    }};

    public static Double getRate(String type, String duration) {
        return duration.equals("hour") ? hourlyPrices.get(type) : dailyPrices.get(type);
    }

    private ParkingPrices(){}
}
