package components.userInterface;

import java.util.Scanner;

public interface UserInterface
{
    Scanner stdin = new Scanner(System.in);

    static void displayMessage(String message) {
        System.out.println(message);
    }

    static String getStringInput(String prompt) {
        System.out.println(prompt);
        return stdin.nextLine();
    }

    static boolean validateMultipleChoice(String input, String[] choices) {
        boolean res = false;
        for (String value : choices) {
            res = value.equals(input) || res;
        }
        return res;
    }
}
