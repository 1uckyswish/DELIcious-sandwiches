package com.pluralsight;

import com.pluralsight.userinterfaces.OrderScreen;

import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------------------------");
        System.out.println("\t\t\t\t\tWelcome to");
        System.out.println("\t\t\t🥪 DELI-CIOUS sandwiches 🥪");
        System.out.println("\t\t  - Your Ultimate sandwich shop! - \t");
        System.out.println("------------------------------------------------------");

        while(true){
            System.out.println("--- Home screen ---");
            System.out.println("1️⃣ - New Order🧾");
            System.out.println("2️⃣ - Exit👋🏻");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    OrderScreen order = new OrderScreen();
                    order.run();
                    break; // Added a break statement to an exit switch case
                case "2":
                    System.out.println("Exiting...");
                    System.exit(0);
                    return; // Exiting the program
                default:
                    System.out.println("Invalid choice. Please enter again.");
                    break;
            }
        }
    }
}
