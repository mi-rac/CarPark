package components.IDreader;

import components.userInterface.UserInterface;

public class IDreader
{
    public static String getRegNum() {
        return UserInterface.getStringInput("Please enter registration number.");
    }

    public static String getVehicleType() {
        return UserInterface.multipleChoice("Please enter vehicle type. ", new String[]{"car", "motorcycle", "van"});
    }
}
