package main;

import java.util.HashMap;

public class ParkingPrices
{
    private static HashMap<String, Double> hourlyPrices;
    private static HashMap<String, Double> dailyPrices;

    static {
        initHourlyPrices();
        initDailyPrices();
    }
    private static void initHourlyPrices(){
        hourlyPrices = new HashMap<>();
        // add prices for cars, motorcycles, and vans
        hourlyPrices.put("car", 2.0);
        hourlyPrices.put("motorcycle", 1.8);
        hourlyPrices.put("van", 2.4);
    }
    private static void initDailyPrices(){
        dailyPrices = new HashMap<>();
        // add prices for cars, motorcycles, and vans
        dailyPrices.put("car", 9.89);
        dailyPrices.put("motorcycle", 8.49);
        dailyPrices.put("van", 11.49);
    }
    public static Double getRate(String type, String duration) {
        return duration.equals("hour") ? hourlyPrices.get(type) : dailyPrices.get(type);
    }
    private ParkingPrices(){}
}
