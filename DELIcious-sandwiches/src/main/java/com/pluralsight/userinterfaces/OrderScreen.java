package com.pluralsight.userinterfaces;

import com.pluralsight.models.*;
import com.pluralsight.utilitymethods.UtilityMethods;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderScreen {
    private List<Sandwich> sandwichCart;
    private List<Drink> drinkCart;
    private List<Chip> chipCart;
    private double totalPrice;
    private static Scanner scanner = new Scanner(System.in);

    public OrderScreen() {
        this.sandwichCart = new ArrayList<>();
        this.drinkCart = new ArrayList<>();
        this.chipCart = new ArrayList<>();
        totalPrice = 0.00;
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
                    userSandwichInterface();
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
                    System.out.println("\nExiting...\n");
                    return false; // Exit the method and indicate that the user chose to exit
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    private void userSandwichInterface(){
        System.out.println("\nWhich sandwich would you like to order?");
        System.out.println("+----------------------------------+");
        System.out.println("| 1️⃣ - Custom Sandwich🥪?          |");
        System.out.println("| 2️⃣ - Signature Sandwich🥪?       |");
        System.out.print("\nEnter your choice: ");
        String userChoice = scanner.nextLine().trim();
        switch (userChoice){
            case "1":
                addCustomSandwich();
                break;
            case "2":
                addSignatureSandwich();
                break;
            default:
                System.out.println("Invalid choice. Please enter again.");
        }
    }

    private void addSignatureSandwich() {
        CreateSandwich sandwichCreator = new CreateSandwich(scanner);

        Scanner scanner = new Scanner(System.in);

        String choice = "";
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println("Would you like to order a BLT or a Philly sandwich?");
            System.out.print("Enter 'BLT' or 'Philly': ");
            choice = scanner.nextLine().trim();

            switch (choice.toUpperCase()) {
                case "BLT":
                    System.out.print("Would you like to modify the BLT sandwich? (Y/N): ");
                    validChoice = true;
                    break;
                case "PHILLY":
                    System.out.print("Would you like to modify the Philly sandwich? (Y/N): ");
                    validChoice = true;
                    break;
                default:
                    System.out.println("\n ** Invalid choice. Please enter either 'BLT' or 'Philly'.** \n");
                    break;
            }
        }

        String modifyChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like to modify the sandwich? (Y/N): ");
        Sandwich sandwich;

        if (modifyChoice.equalsIgnoreCase("Y")) {
            switch (choice.toUpperCase()) {
                case "BLT":
                    sandwich = sandwichCreator.customSignatureSandwich("BLT");
                    break;
                case "PHILLY":
                    sandwich = sandwichCreator.customSignatureSandwich("Philly");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter either 'BLT' or 'Philly'.");
                    return; // Exit method if choice is invalid
            }
        } else {
            switch (choice.toUpperCase()) {
                case "BLT":
                    sandwich = new BLT();
                    break;
                case "PHILLY":
                    sandwich = new Philly();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter either 'BLT' or 'Philly'.");
                    return; // Exit method if choice is invalid
            }
        }

        System.out.print("Would you like a side of 4oz Au Jus Sauce🍲? (Y/N): ");
        String sideChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like a side of 4oz Au Jus Sauce🍲? (Y/N): ");
        if (sideChoice.equalsIgnoreCase("Y")){
            sandwich.addRegularTopping("4oz Au Jus sauce");
        }

        System.out.println("\n  🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪");
        System.out.println(" 🥪 Signature Sandwich Added 🥪");
        System.out.println("  🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪");

        sandwichCart.add(sandwich);
    }



    private void addCustomSandwich() {
            // Create an instance of CreateSandwich class
            CreateSandwich sandwichCreator = new CreateSandwich(scanner);

            // Call createSandwich method to create a sandwich
            Sandwich newSandwich = sandwichCreator.createSandwich();
            // Add the created sandwich to sandwichCart
        System.out.println("\n~~ Custom sandwich successfully added! ~~");
            sandwichCart.add(newSandwich);

    }

    private void addDrink() {
        // Implement drink creation logic
        CreateDrink drinkCreator = new CreateDrink(scanner);

        Drink newDrink = drinkCreator.createDrink();

        drinkCart.add(newDrink);
    }

    private void addChips() {
        CreateChip chipCreator = new CreateChip(scanner);
        Chip newChip = chipCreator.createChips();
        chipCart.add(newChip);
    }

    private void checkoutCart() {
        System.out.println("\n======================================");
        System.out.println("|          Order Overview            |");
        System.out.println("======================================\n");

        if (sandwichCart.isEmpty() && drinkCart.isEmpty() && chipCart.isEmpty()) {
            System.out.println("Your cart is empty. Please add items to proceed with checkout.");
            return;
        }

        double sandwichTotal = 0.00;
        System.out.println("~~ Sandwiches ~~");
        if (!sandwichCart.isEmpty()) {
            for (Sandwich sandwich : sandwichCart){
                if (sandwich instanceof BLT) {
                    sandwichTotal += ((BLT) sandwich).getPrice();
                } else {
                    sandwichTotal += sandwich.calculateTotalPrice();
                }
                System.out.println(sandwich);
            }
        } else {
            System.out.println("No sandwiches in cart.\n");
        }

        double drinkTotal = 0.00;
        System.out.println("~~ Drinks ~~");
        if (!drinkCart.isEmpty()) {
            for (Drink drink : drinkCart){
                drinkTotal += drink.getPrice();
                System.out.println(drink);
            }
        } else {
            System.out.println("No drinks in cart.\n");
        }

        double chipTotal = 0.00;
        System.out.println("~~ Chips ~~");
        if (!chipCart.isEmpty()) {
            for (Chip chip : chipCart){
                chipTotal += chip.getPrice();
                System.out.println(chip);
            }
        } else {
            System.out.println("No chips in cart.\n");
        }

        totalPrice = sandwichTotal + drinkTotal + chipTotal;
        System.out.printf("Total Price: $%,.2f\n", totalPrice);

        System.out.println("\nWhat would you like to do now?");
        System.out.println("1️⃣ Proceed to checkout");
        System.out.println("2️⃣ Cancel order");
        System.out.println("3️⃣ Continue shopping");
        System.out.print("Enter your choice (1, 2, 3): ");
        String userChoice = scanner.nextLine().trim();
        switch (userChoice){
            case "1" -> {
                createReceipt();
                System.out.println("\nThank you for choosing DELI-CIOUS Sandwiches!");
                System.out.println("\nWe appreciate your business.");
                return;
            }
            case "2" -> {
                clearCart();
                return;
            }
            case "3" -> {
                run();
                break;
            }
            default ->   System.out.println("Invalid choice. Please enter again.");
        }
    }

    private void createReceipt(){
        // Get the current date
        Date currentDate = new Date();
        // Define the desired date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        // Format the current date
        String formattedDate = dateFormat.format(currentDate);
        String filePath = "/Users/butterflycoupe/Desktop/YearUp/DELIcious-sandwiches/DELIcious-sandwiches/DELIcious-sandwiches/Receipts/" + formattedDate + ".txt";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write("======================================\n");
            writer.write("              SANDWICHES              \n");
            writer.write("======================================\n");
            writer.newLine();
            if (!sandwichCart.isEmpty()) {
                for (Sandwich sandwich : sandwichCart){
                    writer.write(String.valueOf(sandwich));
                    writer.newLine();
                }
            } else {
                writer.write("No sandwiches Ordered\n");
                writer.newLine();
            }

            writer.write("\n======================================\n");
            writer.write("                DRINKS                \n");
            writer.write("======================================\n");
            writer.newLine();
            if(!drinkCart.isEmpty()){
                for (Drink drink : drinkCart){
                    writer.write(String.valueOf(drink));
                    writer.newLine();
                }
            } else {
                writer.write("No Drinks Ordered\n");
                writer.newLine();
            }


            writer.write("\n======================================\n");
            writer.write("                CHIPS                 \n");
            writer.write("======================================\n");
            writer.newLine();

            if(!chipCart.isEmpty()){
                for (Chip chip : chipCart){
                    writer.write(String.valueOf(chip));
                    writer.newLine();
                }
            }else {
                writer.write("No Chips Ordered\n");
                writer.newLine();
            }


            // Total Price
            // Total Price
            String totalPriceLine = String.format("Total Price: $%.2f", totalPrice);
            int totalLength = totalPriceLine.length();
            int padding = (42 - totalLength) / 2; // Assuming the total line length is 42 characters
            String paddingStr = " ".repeat(padding);

            writer.write("\n==============================================\n");
            writer.write(paddingStr + totalPriceLine + paddingStr + "\n");
            writer.write("==============================================\n");


            // Ending
            writer.write("==============================================\n");
            writer.write("  Thank you for your order! Enjoy your meal!  \n");
            writer.write("==============================================\n");
            writer.write("Store Name:    DELI-CIOUS Sandwiches\n");
            writer.write("Address:       726 Java drive, Bronx, NY, \n");
            writer.write("Manager:       James Gosling\n");
            writer.write("Established:   May 12, 1995\n");
            writer.write("Hours:         Monday - Saturday: 10:00 AM - 8:00 PM\n");
            writer.write("               Sunday: 11:00 AM - 6:00 PM\n");
            writer.write("Phone:         (800) 223-1711\n");
            writer.write("Website:       www.delicious-sandwiches.com\n");
            writer.write("\n");
            writer.write("Thank you for choosing DELI-CIOUS Sandwiches!\n");
            writer.write("We appreciate your business.\n");

            writer.flush();
            writer.close();
            clearCart();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public void clearCart(){
        sandwichCart.clear();
        drinkCart.clear();
        chipCart.clear();
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
