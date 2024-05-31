package com.pluralsight;

import com.pluralsight.userinterfaces.OrderScreen;

import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args) {
        // Create a scanner object to receive user input
        Scanner scanner = new Scanner(System.in);

        // Display a welcome message to the user
        System.out.println("------------------------------------------------------");
        System.out.println("\t\t\t\t\tWelcome to");
        System.out.println("\t\t\t🥪 DELI-CIOUS sandwiches 🥪");
        System.out.println("\t\t  - Your Ultimate sandwich shop! - \t");
        System.out.println("------------------------------------------------------");

        // Handle user input for options
        while (true) {
            System.out.println("--- Home screen ---");
            System.out.println("1️⃣ - New Order🧾");
            System.out.println("2️⃣ - Exit👋🏻");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                // Create a new OrderScreen object for placing a new order
                case "1":
                    OrderScreen order = new OrderScreen();
                    // Run the order screen application
                    order.run();
                    break;
                case "2":
                    // Display an exit message and terminate the program
                    System.out.println("\nExiting...\n");
                    System.exit(0);
                    return;
                default:
                    // Display error message for invalid input
                    System.out.println("Invalid choice. Please enter again.");
                    break;
            }
        }
    }
}