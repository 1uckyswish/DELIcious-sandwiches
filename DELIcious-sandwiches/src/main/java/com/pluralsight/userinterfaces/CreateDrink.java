package com.pluralsight.userinterfaces;

import com.pluralsight.models.Drink;
import com.pluralsight.utilitymethods.UtilityMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateDrink {
    private static Scanner scanner;
    private List<String> drinkChoices = beverageChoices();

    public CreateDrink(Scanner scanner){
        this.scanner = scanner;
    }

    public Drink createDrink(){
        Drink drink;
        String drinkSize;
        String drinkType;
        double drinkPrice;

        System.out.println("\n======================================");
        System.out.println("|          Ordering Beverage         |");
        System.out.println("======================================\n");

        System.out.println("What size drink would you like?");
        System.out.println("1️⃣ Small");
        System.out.println("2️⃣ Medium");
        System.out.println("3️⃣ Large");
        System.out.print("Enter your choice (1, 2, 3): ");
        String sizeChoice = UtilityMethods.takeSizeInput(scanner, scanner.nextLine().trim(), "\nEnter your choice (1, 2, 3): ");
        drinkSize = (sizeChoice.equals("1") ? "Small" : sizeChoice.equals("2") ? "Medium" : "Large");
        drinkPrice = (drinkSize.equals("Small") ? 2.00 : drinkSize.equals("Medium") ? 2.50 : 3.00);
        drinkType = UtilityMethods.validateBeverageChoice(scanner, drinkChoices);
        drink = new Drink(drinkSize, drinkType, true, drinkPrice);

        System.out.println("\n  🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤");
        System.out.println("     🥤  Beverage Added  🥤");
        System.out.println("  🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤🥤");

        return drink;
    }



    private List<String> beverageChoices(){
        List<String> beverageChoices = new ArrayList<>();
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
