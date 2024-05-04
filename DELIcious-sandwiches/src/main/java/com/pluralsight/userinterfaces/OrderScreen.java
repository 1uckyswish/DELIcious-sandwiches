package com.pluralsight.userinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderScreen {
    private List<String> sandwichCart;
    private List<String> drinkCart;
    private List<String> chipCart;
    private double totalPrice;
    private static Scanner scanner = new Scanner(System.in);

    public OrderScreen() {
        this.sandwichCart = new ArrayList<>();
        this.drinkCart = new ArrayList<>();
        this.chipCart = new ArrayList<>();
        this.totalPrice = 0.00;
    }

    public boolean run() {
        while (true) {
            System.out.println("\n+--------------------------------------+");
            System.out.println("|             ORDER SCREEN             |");
            System.out.println("+--------------------------------------+");
            System.out.println("| 1️⃣ - Would you like a Sandwich🥪?    |");
            System.out.println("| 2️⃣ - Would you like a Drink🥤?       |");
            System.out.println("| 3️⃣ - Would you like Chips🥫?         |");
            System.out.println("| 4️⃣ - Checkout💰                      |");
            System.out.println("| 5️⃣ - Exit👋🏻                          |");
//            System.out.println("+--------------------------------------+");
            System.out.print("\nEnter your choice: ");

            String orderChoice = scanner.nextLine().trim().toLowerCase();

            switch (orderChoice) {
                case "1":
                    addSandwich();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    checkoutCart();
                    break;
                case "6":
                    System.out.println(sandwichCart);
                    System.out.println(drinkCart);
                    System.out.println(chipCart);
                    break;
                case "5":
                    exitBackHome();
                    System.out.println("Exiting...");
                    return false; // Exit the method and indicate that the user chose to exit
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    private void addSandwich() {
        // Create an instance of CreateSandwich class
        CreateSandwich sandwichCreator = new CreateSandwich(scanner);

        // Call createSandwich method to create a sandwich
        String newSandwich = sandwichCreator.createSandwich();
        // Add the created sandwich to sandwichCart
        sandwichCart.add(newSandwich);
    }

    private void addDrink() {
        // Implement drink creation logic
        CreateDrink drinkCreator = new CreateDrink(scanner);

        String newDrink = drinkCreator.createDrink();

        drinkCart.add(newDrink);
    }

    private void addChips() {
        CreateChip chipCreator = new CreateChip(scanner);
        String newChip = chipCreator.createChips();
        chipCart.add(newChip);
    }

    private void checkoutCart() {
        // Implement checkout logic
    }

    private void exitBackHome() {
        if (sandwichCart.size() > 0 || drinkCart.size() > 0 || chipCart.size() > 0) {
            while (true) {
                System.out.println("\nBefore proceeding, would you like to confirm your choices?");
                System.out.println("Please note that this action will clear all items from your cart.");
                System.out.print("Confirm with 'Yes' or 'No': ");
                String userChoice = scanner.nextLine().trim();
                if (userChoice.equalsIgnoreCase("yes")) {
                    return;
                } else if (userChoice.equalsIgnoreCase("no")) {
                        run();
                    return;
                } else {
                    System.out.println("Invalid choice. Please enter 'Yes' or 'No'.");
                }
            }
        }
    }


}
