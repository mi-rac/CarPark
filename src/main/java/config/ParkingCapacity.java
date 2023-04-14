package config;

import java.util.HashMap;
import java.util.Map;

public class ParkingCapacity
{
    private static final Map<String, Integer> capacity = new HashMap<String, Integer>(){static {
        // add prices for cars, motorcycles, and vans
        capacity.put("car", 50);
        capacity.put("motorcycle", 10);
        capacity.put("van", 6);
    }};

    public static Integer getCapacity(String type) {
        return capacity.get(type);
    }

    private ParkingCapacity(){}
}
