package main;

import components.parkingSession.CarParkingSession;
import components.vehicle.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("AB123CD");
    }

    @Test
    void getRegNum() {
        assertEquals("AB123CD", car.getRegNum());
    }

    @Test
    void getSession() {
        assertNotNull(car.getSession());
        assertTrue(car.getSession() instanceof CarParkingSession);
    }
}
