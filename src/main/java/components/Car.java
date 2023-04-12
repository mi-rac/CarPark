package components;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String licensePlate, String make, String model, int numberOfDoors) {
        super(licensePlate, make, model);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
