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

    public String createDrink(){
        Drink drink;
        String drinkSize;
        String drinkType;
        double drinkPrice;

        System.out.println("\n======================================");
        System.out.println("|          Beverage Ordering         |");
        System.out.println("======================================\n");

        System.out.println("\nWhat size drink would you like?");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Larger");
        System.out.print("Enter your choice (1, 2, 3): ");
        String sizeChoice = UtilityMethods.takeSizeInput(scanner, scanner.nextLine().trim(), "Enter your choice (1, 2, 3): ");
        drinkSize = (sizeChoice.equals("1") ? "Small" : sizeChoice.equals("2") ? "Medium" : "Large");
        drinkPrice = (drinkSize.equals("Small") ? 2.00: drinkSize.equals("Medium") ? 2.50 : 3.00);




        return "noel";
    }



    private List<String> beverageChoices(){
        List<String> beverageChoices = new ArrayList<>();
        beverageChoices.add("Chocolate Milkshake");
        beverageChoices.add("Pink Lemonade");
        beverageChoices.add("Sweet Iced Tea");
        beverageChoices.add("Iced Coffee");
        beverageChoices.add("Earl GreyTea");
        beverageChoices.add("Orange Juice");
        beverageChoices.add("Bud Light");
        beverageChoices.add("Sprite");
        beverageChoices.add("Pepsi");
        return beverageChoices;
    }
}
