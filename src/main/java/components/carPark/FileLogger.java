package components.carPark;

import components.vehicle.Vehicle;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileLogger {
    private static String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }
    public static void updateInfo() {
        CarPark cp = CarPark.getInstance();
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
            for (Vehicle vehicle : (List<Vehicle>) cp.getParkingList("car").getVehicles()) {
                writer.write(vehicle.toString() + "\n");
            }
            for (Vehicle vehicle : (List<Vehicle>) cp.getParkingList("motorcycle").getVehicles()) {
                writer.write(vehicle.toString() + "\n");
            }
            for (Vehicle vehicle : (List<Vehicle>) cp.getParkingList("van").getVehicles()) {
                writer.write(vehicle.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
