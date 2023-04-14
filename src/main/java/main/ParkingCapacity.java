package main;

import java.util.HashMap;

public class ParkingCapacity
{
    private static HashMap<String, Integer> capacity;

    static {
        initCapacity();
    }

    private static void initCapacity() {
        capacity = new HashMap<>();
        // add prices for cars, motorcycles, and vans
        capacity.put("car", 50);
        capacity.put("motorcycle", 10);
        capacity.put("van", 2);
    }

    public static Integer getCapacity(String type) {
        return capacity.get(type);
    }

    private ParkingCapacity(){}
}
