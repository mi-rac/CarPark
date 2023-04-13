package components;

import java.util.HashMap;

public interface CarParkConfig
{
    HashMap<String, int> parkingSpots = new HashMap<String, int>(){static {
        // add prices for cars, motorcycles, and vans
        parkingSpots.put("car", 50);
        parkingSpots.put("motorcycle", 10);
        parkingSpots.put("van", 6);
    }};
}
