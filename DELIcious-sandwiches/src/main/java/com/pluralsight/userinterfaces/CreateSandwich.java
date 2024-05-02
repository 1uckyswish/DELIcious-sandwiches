package com.pluralsight.userinterfaces;
import com.pluralsight.models.Sandwich;
import com.pluralsight.utilitymethods.UtilityMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateSandwich {
    private Scanner scanner;
    private List<String> meatToppings = loadMeatToppings();
    private List<String> cheeseToppings = loadCheeseToppings();
    private List<String> regularToppings = loadRegularToppings();
    private List<String> sauceOptions = loadSauceToppings();

    public CreateSandwich(Scanner scanner) {
        this.scanner = scanner;
    }

    public String createSandwich() {
        Sandwich sandwich;
        String sandwichSize;
        String sandwichBread;
        boolean isToasted;
        System.out.println("Creating a new sandwich:");

        // Sandwich bread
        System.out.println("Select your bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        System.out.print("Enter your choice (1, 2, 3, 4): ");
        String breadChoice = UtilityMethods.takeBreadTypeInput(scanner, scanner.nextLine().trim(), "Enter your choice (1, 2, 3, 4): ");
        sandwichBread = (breadChoice.equals("1") ? "White" : breadChoice.equals("2") ? "Wheat" : breadChoice.equals("3") ? "Rye" : "Wrap");
        // Sandwich size
        System.out.println("What size sandwich would you like?");
        System.out.println("Sandwich size:");
        System.out.println("1) 4-inch");
        System.out.println("2) 8-inch");
        System.out.println("3) 12-inch");
        System.out.print("Enter your choice (1, 2, 3): ");
        String sizeChoice = UtilityMethods.takeBreadSizeInput(scanner, scanner.nextLine().trim(), "Enter your choice (1, 2, 3): ");
        sandwichSize = (sizeChoice.equals("1") ? "4" : sizeChoice.equals("2") ? "8" : "12");

        System.out.print("Would you like the bread toasted? (Y/N): ");
        String toastChoice = UtilityMethods.takeBreadToastedInput(scanner, scanner.nextLine().trim(), "Would you like the bread toasted? (Y/N): ");
        isToasted = (toastChoice.equalsIgnoreCase("Y") ? true : false);
        //Make new object to access methods
        sandwich = new Sandwich(sizeChoice, breadChoice, isToasted);

        return "hello";
    }




    private static List<String> loadMeatToppings() {
        List<String> meatToppings = new ArrayList<>();
        meatToppings.add("Steak");
        meatToppings.add("Ham");
        meatToppings.add("Salami");
        meatToppings.add("Roast Beef");
        meatToppings.add("Chicken");
        meatToppings.add("Bacon");
        return meatToppings;
    }

    private static List<String> loadCheeseToppings() {
        List<String> cheeseToppings = new ArrayList<>();
        cheeseToppings.add("American");
        cheeseToppings.add("Provolone");
        cheeseToppings.add("Cheddar");
        cheeseToppings.add("Swiss");
        return cheeseToppings;
    }

    private static List<String> loadRegularToppings() {
        List<String> regularToppings = new ArrayList<>();
        regularToppings.add("Lettuce");
        regularToppings.add("Peppers");
        regularToppings.add("Onions");
        regularToppings.add("Tomatoes");
        regularToppings.add("Jalepenos");
        regularToppings.add("Cucumbers");
        regularToppings.add("Pickles");
        regularToppings.add("Guacamole");
        regularToppings.add("Mushrooms");
        return regularToppings;
    }


    private static List<String> loadSauceToppings() {
        List<String> sauceToppings = new ArrayList<>();
        sauceToppings.add("Mayo");
        sauceToppings.add("Mustard");
        sauceToppings.add("Ketchup");
        sauceToppings.add("Ranch");
        sauceToppings.add("Thousand Island");
        sauceToppings.add("Vinaigrette");
        return sauceToppings;
    }
}

