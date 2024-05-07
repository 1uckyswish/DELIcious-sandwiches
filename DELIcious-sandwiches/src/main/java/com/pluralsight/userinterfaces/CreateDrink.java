/**
 * Represents the interface for creating a beverage order.
 * This class handles the creation of drink objects based on user input.
 */
package com.pluralsight.userinterfaces;

import com.pluralsight.models.Drink;
import com.pluralsight.utilitymethods.UtilityMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateDrink {
    private static Scanner scanner;
    private final List<String> drinkChoices = beverageChoices();

    /**
     * Constructs a CreateDrink object with the provided scanner.
     * @param scanner The scanner object used for user input.
     */
    public CreateDrink(Scanner scanner) {
        CreateDrink.scanner = scanner;
    }

    /**
     * Creates a drink object based on user input.
     * @return The created drink object.
     */
    public Drink createDrink() {
        Drink drink;
        String drinkSize;
        String drinkType;
        double drinkPrice;

        System.out.println("\n======================================");
        System.out.println("|          Ordering Beverage         |");
        System.out.println("======================================\n");

        // Prompt user to select drink size
        System.out.println("What size drink would you like?");
        System.out.println("1️⃣ Small");
        System.out.println("2️⃣ Medium");
        System.out.println("3️⃣ Large");
        System.out.print("Enter your choice (1, 2, 3): ");
        String sizeChoice = UtilityMethods.takeSizeInput(scanner, scanner.nextLine().trim(),
                "\nEnter your choice (1, 2, 3): ");
        drinkSize = (sizeChoice.equals("1") ? "Small" : sizeChoice.equals("2") ? "Medium" : "Large");
        drinkPrice = (drinkSize.equals("Small") ? 2.00 : drinkSize.equals("Medium") ? 2.50 : 3.00);

        // Prompt user to select drink type
        drinkType = UtilityMethods.validateBeverageChoice(scanner, drinkChoices);

        // Create drink object with user choices
        drink = new Drink(drinkSize, drinkType, true, drinkPrice);

        // Confirmation message
        System.out.println("\n  🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤");
        System.out.println("     🥤  Beverage Added  🥤");
        System.out.println("  🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤");

        return drink;
    }

    /**
     * Loads the list of available beverage choices.
     * @return A list of available beverage choices.
     */
    private List<String> beverageChoices() {
        List<String> beverageChoices = new ArrayList<>();
        // Populate list with available beverage choices
        beverageChoices.add("Milkshake");
        beverageChoices.add("Iced Coffee");
        beverageChoices.add("Sweet Tea");
        beverageChoices.add("Corona Light");
        beverageChoices.add("Bud Light");
        beverageChoices.add("Sprite");
        beverageChoices.add("Fanta");
        beverageChoices.add("Coke");
        beverageChoices.add("Water");
        return beverageChoices;
    }
}
