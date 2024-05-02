package com.pluralsight.utilitymethods;
import java.util.Scanner;

public class UtilityMethods {

    public static String takeBreadSizeInput(Scanner scanner, String value, String prompt) {
        while (!value.equals("1") && !value.equals("2") && !value.equals("3")) {
            System.out.println("Sorry, please enter one of the values from above: ");
            // After invalid input, read the next integer value
            System.out.print(prompt);
            value = scanner.nextLine();
        }
        return value;
    }

    public static String takeBreadTypeInput(Scanner scanner, String value, String prompt) {
        while (!value.equals("1") && !value.equals("2") && !value.equals("3") && !value.equals("4")) {
            System.out.println("Sorry, please enter one of the values from above: ");
            // After invalid input, read the next integer value
            System.out.print(prompt);
            value = scanner.nextLine();
        }
        return value;
    }

    public static String takeBreadToastedInput(Scanner scanner, String value, String prompt) {
        while (!value.equalsIgnoreCase("Y") && !value.equalsIgnoreCase("N")) {
            System.out.println("Sorry, please enter either (Y/N): ");
            // After invalid input, read the next integer value
            System.out.print(prompt);
            value = scanner.nextLine().trim();
        }
        return value;
    }
}
