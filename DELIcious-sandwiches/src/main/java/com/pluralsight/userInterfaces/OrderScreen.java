package com.pluralsight.userInterfaces;

import com.pluralsight.HomeScreen;

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
            System.out.println("ORDER SCREEN");
            System.out.println("1) Would you like a Sandwich?");
            System.out.println("2) Would you like a drink?");
            System.out.println("3) Would you like a bag of chips?");
            System.out.println("4) Checkout");
            System.out.println("5) Exit");
            System.out.print("Enter your choice: ");
            String orderChoice = scanner.nextLine().trim().toLowerCase();

            switch (orderChoice) {
                case "1":
                    addSandwich();
                    break;
                case "2":
                    createDrink();
                    break;
                case "3":
                    createChips();
                    break;
                case "4":
                    checkoutCart();
                    break;
                case "6":
                    System.out.println(sandwichCart);
                    break;
                case "5":
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
        String newSandwich;
        newSandwich = sandwichCreator.createSandwich();

        // Add the created sandwich to sandwichCart
        sandwichCart.add(newSandwich);
    }

    private void createDrink() {
        // Implement drink creation logic
    }

    private void createChips() {
        // Implement chips creation logic
    }

    private void checkoutCart() {
        // Implement checkout logic
    }

}
