package components;

import java.util.ArrayList;
import java.util.List;

public class CarPark {
    private String carParkName;
    private int carParkCapacity;
    private double carParkFee;
    private List<Car> parkedCars;

    public CarPark(String carParkName, int carParkCapacity, double carParkFee) {
        this.carParkName = carParkName;
        this.carParkCapacity = carParkCapacity;
        this.carParkFee = carParkFee;
        parkedCars = new ArrayList<Car>();
    }

    public boolean parkCar(Car car) {
        if (parkedCars.size() < carParkCapacity) {
            parkedCars.add(car);
            return true;
        }
        return false;
    }

    public boolean removeCar(Car car) {
        if (parkedCars.contains(car)) {
            parkedCars.remove(car);
            return true;
        }
        return false;
    }

    public double calculateParkingFee(Ticket ticket) {
        double hoursParked = ticket.getHoursParked();
        return carParkFee * hoursParked;
    }

    // Getters and setters
    public String getCarParkName() {
        return carParkName;
    }

    public void setCarParkName(String carParkName) {
        this.carParkName = carParkName;
    }

    public int getCarParkCapacity() {
        return carParkCapacity;
    }

    public void setCarParkCapacity(int carParkCapacity) {
        this.carParkCapacity = carParkCapacity;
    }

    public double getCarParkFee() {
        return carParkFee;
    }

    public void setCarParkFee(double carParkFee) {
        this.carParkFee = carParkFee;
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }
}
