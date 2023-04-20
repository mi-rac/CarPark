package components.IDreader;

import components.userInterface.UserInterface;

public abstract class IDReader
{
    protected IDReader(){}
    protected String getID(String id) {
        return UserInterface.getStringInput(String.format("Please enter your %s.", id));
    }

    public String getVehicleType() {
        return UserInterface.multipleChoice("Please enter vehicle type. ", new String[]{"car", "motorcycle", "van"});
    }
}
