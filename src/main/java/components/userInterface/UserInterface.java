package components.userInterface;

import java.util.Arrays;
import java.util.Scanner;

public class UserInterface
{
    static Scanner stdin = new Scanner(System.in);

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static String getStringInput(String prompt) {
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

    public static String multipleChoice(String prompt, String[] choices) {
        String input;
        do {
            input = getStringInput(prompt.concat(Arrays.toString(choices)));
        }
        while (!UserInterface.validateMultipleChoice(input, choices));
        return input;
    }
}
