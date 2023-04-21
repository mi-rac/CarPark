package main;

import components.carPark.ParkingList;
import components.vehicle.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingListTest {
    private ParkingList<Car> parkingList;

    @BeforeEach
    void setUp() {
        parkingList = new ParkingList<>(3);
    }

    @Test
    void addVehicle() {
        Car car1 = new Car("AB123CD");
        Car car2 = new Car("DE456FG");
        Car car3 = new Car("HI789JK");
        Car car4 = new Car("LM012NO");

        assertTrue(parkingList.addVehicle(car1));
        assertTrue(parkingList.addVehicle(car2));
        assertTrue(parkingList.addVehicle(car3));
        assertFalse(parkingList.addVehicle(car4));
    }

    @Test
    void removeVehicle() {
        Car car1 = new Car("AB123CD");
        Car car2 = new Car("DE456FG");

        parkingList.addVehicle(car1);
        parkingList.addVehicle(car2);

        assertTrue(parkingList.removeVehicle(car1));
        assertFalse(parkingList.removeVehicle(car1));
    }

    @Test
    void getVehicles() {
        Car car1 = new Car("AB123CD");
        Car car2 = new Car("DE456FG");

        parkingList.addVehicle(car1);
        parkingList.addVehicle(car2);

        List<Car> vehicles = parkingList.getVehicles();
        assertEquals(2, vehicles.size());
        assertTrue(vehicles.contains(car1));
        assertTrue(vehicles.contains(car2));
    }
}

