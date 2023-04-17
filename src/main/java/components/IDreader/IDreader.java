package components.IDreader;

import components.userInterface.UserInterface;

public abstract class IDreader
{
    void String readID() {
        regNum = UserInterface.getStringInput("Please enter registration number.");
        type = UserInterface.multipleChoice("Please enter vehicle type. ", new String[]{"car", "motorcycle", "van"});
    }
}
