package com.pluralsight.utilitymethods;
import java.util.List;
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


    public static String takeYesOrNoInput(Scanner scanner, String value, String prompt) {
        while (!value.equalsIgnoreCase("Y") && !value.equalsIgnoreCase("N")) {
            System.out.println("Sorry, please enter either (Y/N): ");
            // After invalid input, read the next value
            System.out.print(prompt);
            value = scanner.nextLine().trim();
        }
        return value;
    }


    public static String validateMeatChoice(Scanner scanner, List<String> meatOptions) {
        while (true) {
            System.out.println("Choose One Meat To add ");
            for (String meat : meatOptions) {
                System.out.println("❥ " + meat);
            }



            System.out.print("Enter your choice: ");
            String selectedMeat = scanner.nextLine().trim();

            for (String meat : meatOptions) {
                if (selectedMeat.equalsIgnoreCase(meat)) {
                    return selectedMeat; // Input matches one of the meat options
                }
            }

            System.out.println("Invalid meat choice. Please choose one of the available options.");
        }
    }


    public static String validateCheeseChoice(Scanner scanner, List<String> cheeseOptions) {
        while (true) {
            System.out.println("Choose One Cheese To add ");
            for (String cheese : cheeseOptions) {
                System.out.println("❥ " + cheese);
            }

            System.out.print("Enter your choice: ");
            String selectedCheese = scanner.nextLine().trim();

            for (String cheese : cheeseOptions) {
                if (selectedCheese.equalsIgnoreCase(cheese)) {
                    return selectedCheese; // Input matches one of the meat options
                }
            }

            System.out.println("Invalid Cheese choice. Please choose one of the available options.");
        }
    }


    public static String validateToppingsChoice(Scanner scanner, List<String> toppingOptions) {
        while (true) {
            System.out.println("Choose One Topping To add ");
            for (String topping : toppingOptions) {
                System.out.println("❥ " + topping);
            }
            System.out.print("Enter your choice: ");
            String selectedTopping = scanner.nextLine().trim();

            for (String topping : toppingOptions) {
                if (selectedTopping.equalsIgnoreCase(topping)) {
                    return selectedTopping; // Input matches one of the meat options
                }
            }

            System.out.println("Invalid Topping choice. Please choose one of the available options.");
        }
    }
}
