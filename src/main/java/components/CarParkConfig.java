package components;

import java.util.HashMap;

public interface CarParkConfig
{
    HashMap<String, int> parkingSpotsNo = new HashMap<String, int>(){static {
        // add prices for cars, motorcycles, and vans
        parkingSpotsNo.put("car", 50);
        parkingSpotsNo.put("motorcycle", 10);
        parkingSpotsNo.put("van", 6);
    }};
}
