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
            for (ParkingList list : new ParkingList[]{cp.carSpaces, cp.motorcycleSpaces, cp.vanSpaces}) {
                for (Vehicle vehicle : (List<Vehicle>) list.getVehicles()) {
                    writer.write(vehicle.toString() + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
