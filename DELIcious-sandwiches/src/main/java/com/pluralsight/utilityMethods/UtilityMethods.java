package com.pluralsight.utilityMethods;
import java.util.Scanner;

public class UtilityMethods {

    public static String takeBreadInput(Scanner scanner, String value, String prompt) {
        while (!value.equals("1") && !value.equals("2") && !value.equals("3")) {
            System.out.println("Sorry, please enter one of the values from above: ");
            // After invalid input, read the next integer value
            System.out.print(prompt);
            value = scanner.nextLine();
        }
        return value;
    }
}
