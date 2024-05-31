package com.pluralsight.userinterfaces;

import com.pluralsight.models.*;
import com.pluralsight.utilitymethods.UtilityMethods;

import javax.sound.sampled.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the user interface for placing orders in a sandwich
 * shop application.
 * It handles user interactions, such as selecting items to order,
 * viewing the cart, and checking out.
 */
public class OrderScreen {
    // Attributes for the order screen
    private final List<Sandwich> sandwichCart; // Holds ordered sandwiches
    private final List<Drink> drinkCart; // Holds ordered drinks
    private final List<Chip> chipCart; // Holds ordered chips
    private final List<Cookie> cookieCart; // Holds ordered chips
    private double totalPrice; // Total price of the order
    private static final Scanner scanner = new Scanner(System.in); // Scanner for user input

    /**
     * Constructs an OrderScreen object with empty carts and total price set to 0.
     */
    public OrderScreen() {
        this.sandwichCart = new ArrayList<>();
        this.drinkCart = new ArrayList<>();
        this.chipCart = new ArrayList<>();
        this.cookieCart = new ArrayList<>();
        this.totalPrice = 0.00;
    }

    /**
     * Runs the order screen, allowing users to interact with the application.
     */
    public void run() {
        while (true) {
            // Display main menu options
            System.out.println("\n+--------------------------------------+");
            System.out.println("|             ORDER SCREEN             |");
            System.out.println("+--------------------------------------+");
            System.out.println("| 1️⃣ - Would you like a Sandwich🥪?    |");
            System.out.println("| 2️⃣ - Would you like a Drink🥤?       |");
            System.out.println("| 3️⃣ - Would you like Chips🥫?         |");
            System.out.println("| 4️⃣ - Would you like a Cookie🍪?      |");
            System.out.println("| 5️⃣ - Checkout💰                      |");
            System.out.println("| 6️⃣ - Exit👋🏻                          |");
            System.out.print("\nEnter your choice: ");
            // Take user input
            String orderChoice = scanner.nextLine().trim().toLowerCase();

            // Process user's choice
            switch (orderChoice) {
                case "1":
                    // Handle user selection of sandwich
                    userSandwichInterface();
                    break;
                case "2":
                    // Handle user selection of drink
                    addDrink();
                    break;
                case "3":
                    // Handle user selection of chips
                    addChips();
                    break;
                case "4":
                    addCookieToCart();
                    break;
                case "5":
                    // Proceed to checkout
                    checkoutCart();
                    break;
                case "6":
                    // Prompt user when exiting
                    System.out.println("\nExiting...\n");
                    System.out.println("***************************************************");
                    System.out.println("*                                                 *");
                    System.out.println("*               Thanks for visiting               *");
                    System.out.println("*                                                 *");
                    System.out.println("*            🥪 DELI-CIOUS sandwiches 🥪          *");
                    System.out.println("*                                                 *");
                    System.out.println("*     We hope to see you again soon. Farewell!    *");
                    System.out.println("*                                                 *");
                    System.out.println("***************************************************");

                    System.exit(0);
                    return; // Exit the method and indicate that the user chose to exit
                default:
                    // Display a message for invalid input
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }

    /**
     * Adds a new cookie to the cart.
     * Automatically creates a Cookie object with default values and adds it to the
     * cart.
     */
    public void addCookieToCart() {
        System.out.println("\nChoose the type of cookie:");
        System.out.println("1️⃣ Sugar Cookie❄️");
        System.out.println("2️⃣ Chocolate Chip Cookie🍪");

        String choice;
        do {
            System.out.print("Enter your choice (1 or 2): ");
            choice = scanner.nextLine().trim();

            if (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("Invalid choice. Please enter 1 for Sugar Cookie or 2 for Chocolate Chip Cookie.");
            }
        } while (!choice.equals("1") && !choice.equals("2"));

        String cookieType;
        if (choice.equals("1")) {
            cookieType = "Sugar Cookie";
        } else {
            cookieType = "Chocolate Chip Cookie";
        }

        Cookie myCookie = new Cookie();
        myCookie.setType(cookieType); // Set the type of the Cookie object
        cookieCart.add(myCookie); // Add the Cookie object to the cart
        System.out.println("\n 🍪🍪🍪🍪🍪🍪🍪🍪🍪🍪🍪🍪🍪");
        System.out.println("      🍪 Cookie Added! 🍪");
        System.out.println(" 🍪🍪🍪🍪🍪🍪🍪🍪🍪🍪🍪🍪🍪");

    }

    /**
     * Allows the user to choose between a custom sandwich or a signature sandwich.
     * Handles user input to direct them to the appropriate method.
     */
    private void userSandwichInterface() {
        System.out.println("\nWhich sandwich would you like to order?");
        System.out.println("+----------------------------------+");
        System.out.println("| 1️⃣ - Custom Sandwich🥪?          |");
        System.out.println("| 2️⃣ - Signature Sandwich🥪?       |");
        System.out.print("\nEnter your choice: ");
        String userChoice = scanner.nextLine().trim();
        switch (userChoice) {
            case "1":
                addCustomSandwich(); // Allow user to create a custom sandwich
                break;
            case "2":
                addSignatureSandwich(); // Allow user to select or modify a signature sandwich
                break;
            default:
                System.out.println("Invalid choice. Please enter again.");
        }
    }

    /**
     * Allows the user to select a signature sandwich or modify it.
     * Handles user input for selecting a sandwich type and any modifications.
     */
    private void addSignatureSandwich() {
        CreateSandwich sandwichCreator = new CreateSandwich(scanner); // Interface for creating sandwiches
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        String choice = "";
        boolean validChoice = false; // Flag to validate user's sandwich choice

        while (!validChoice) {
            System.out.println("Would you like to order a BLT or a Philly sandwich?");
            System.out.print("Enter 'BLT' or 'Philly': ");
            choice = scanner.nextLine().trim();

            switch (choice.toUpperCase()) {
                case "BLT":
                case "PHILLY":
                    System.out.print("Would you like to modify the sandwich? (Y/N): ");
                    validChoice = true;
                    break;
                default:
                    System.out.println("\n ** Invalid choice. Please enter either 'BLT' or 'Philly'.** \n");
                    break;
            }
        }

        String modifyChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "Would you like to modify the sandwich? (Y/N): ");
        Sandwich sandwich;

        if (modifyChoice.equalsIgnoreCase("Y")) {
            switch (choice.toUpperCase()) {
                case "BLT":
                case "PHILLY":
                    sandwich = sandwichCreator.customSignatureSandwich(choice);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter either 'BLT' or 'Philly'.");
                    return;
            }
        } else {
            switch (choice.toUpperCase()) {
                case "BLT":
                    sandwich = new BLT(); // Default BLT sandwich
                    break;
                case "PHILLY":
                    sandwich = new Philly(); // Default Philly sandwich
                    break;
                default:
                    System.out.println("Invalid choice. Please enter either 'BLT' or 'Philly'.");
                    return;
            }
        }

        System.out.print("Would you like a side of 4oz Au Jus Sauce🍲? (Y/N): ");
        String sideChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "Would you like a side of 4oz Au Jus Sauce🍲? (Y/N): ");
        if (sideChoice.equalsIgnoreCase("Y")) {
            sandwich.addRegularTopping("4oz Au Jus sauce"); // Add sauce as a topping
        }

        System.out.println("\n  🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪");
        System.out.println(" 🥪 Signature Sandwich Added 🥪");
        System.out.println("  🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪");
        sandwichCart.add(sandwich); // Add the created sandwich to the cart
    }

    /**
     * Method allows the user to create a custom sandwich with no starter base. they
     * select all options
     */
    private void addCustomSandwich() {
        // Create an instance of CreateSandwich class
        CreateSandwich sandwichCreator = new CreateSandwich(scanner);

        // Call createSandwich method to create a sandwich
        Sandwich newSandwich = sandwichCreator.createSandwich();
        // Add the created sandwich to sandwichCart
        sandwichCart.add(newSandwich);

    }

    /**
     * Method allows user to select drink of choice and append to drink cart
     */
    private void addDrink() {
        // Implement drink creation logic
        CreateDrink drinkCreator = new CreateDrink(scanner);
        // Call the method to create a beverage
        Drink newDrink = drinkCreator.createDrink();
        // Add the created drink to drinkCart
        drinkCart.add(newDrink);
    }

    /**
     * Method allows user to select chips of choice and append to chip cart
     */
    private void addChips() {
        // Implement chip creation logic
        CreateChip chipCreator = new CreateChip(scanner);
        // Call the method to create a bag of chips
        Chip newChip = chipCreator.createChips();
        // Add the created chips to chipCart
        chipCart.add(newChip);
    }

    /**
     * Method displays the current cart total and items
     * Method also allows user to check out, clear cart or return home
     */
    private void checkoutCart() {
        System.out.println("\n======================================");
        System.out.println("|          Order Overview            |");
        System.out.println("======================================\n");

        // Check if the cart is empty for all items
        // Return to order screen until items are ordered
        if (sandwichCart.isEmpty() && drinkCart.isEmpty() && chipCart.isEmpty() && cookieCart.isEmpty()) {
            System.out.println("Your cart is empty. Please add items to proceed with checkout.");
            return;
        }

        // Collect data from sandwiches cart
        // gather total of all sandwiches in cart
        double sandwichTotal = 0.00;
        System.out.println("~~ Sandwiches ~~");
        // Check if sandwich cart is not emptily
        // Append the sandwich price to get the total for sandwich
        if (!sandwichCart.isEmpty()) {
            for (Sandwich sandwich : sandwichCart) {
                if (sandwich instanceof BLT) {
                    sandwichTotal += sandwich.getPrice();
                } else {
                    sandwichTotal += sandwich.calculateTotalPrice();
                }
                System.out.println(sandwich);
            }
        } else {
            // Display message if no sandwich is ordered
            System.out.println("No sandwiches in cart.\n");
        }

        // Collect data from drink cart
        // gather total of all drinks in cart
        double drinkTotal = 0.00;
        System.out.println("~~ Drinks ~~");
        // Check if drink cart is not emptily
        // Append the drink price to get the total for drinks
        if (!drinkCart.isEmpty()) {
            for (Drink drink : drinkCart) {
                drinkTotal += drink.getPrice();
                System.out.println(drink);
            }
        } else {
            // Display message if no drinks are ordered
            System.out.println("No drinks in cart.\n");
        }

        // Collect data from chips cart
        // gather total of all chips in cart
        double chipTotal = 0.00;
        System.out.println("~~ Chips ~~");
        // Check if chips cart is not emptily
        // Append the chips price to get the total for chips
        if (!chipCart.isEmpty()) {
            for (Chip chip : chipCart) {
                chipTotal += chip.getPrice();
                System.out.println(chip);
            }
        } else {
            // Display message if no chips are ordered
            System.out.println("No chips in cart.\n");
        }

        // Collect data from cookie cart
        // gather total of all cookies in cart
        double cookieTotal = 0.00;
        System.out.println("~~ Cookies ~~");
        // Check if cookies cart is not emptily
        // Append the cookies price to get the total for cookies
        if (!cookieCart.isEmpty()) {
            for (Cookie cookie : cookieCart) {
                cookieTotal += cookie.getPrice();
                System.out.println(cookie);
            }
        } else {
            // Display message if no cookies are ordered
            System.out.println("No cookies in cart.\n");
        }

        // Accumulate the total for everything
        totalPrice = sandwichTotal + drinkTotal + chipTotal + cookieTotal;
        // Display total
        System.out.print("=====================\n");
        System.out.printf("Total Price: $%,.2f\n", totalPrice);
        System.out.print("=====================\n");

        // Display user new options to choose from
        System.out.println("\nWhat would you like to do now?");
        System.out.println("1️⃣ Proceed to checkout");
        System.out.println("2️⃣ Cancel order");
        System.out.println("3️⃣ Continue shopping");
        System.out.print("Enter your choice (1, 2, 3): ");
        String userChoice = scanner.nextLine().trim();
        // Handle user choice
        switch (userChoice) {
            case "1" -> {
                playSound("/Users/butterflycoupe/Desktop/YearUp/DELIcious-sandwiches/DELIcious-sandwiches/DELIcious-sandwiches/sounds/cash.wav");
                createReceipt();
                System.out.println("\nThank you for choosing DELI-CIOUS Sandwiches!");
                System.out.println("\nWe appreciate your business.");
            }
            case "2" -> {
                clearCart();
                System.out.println("\nCart Cleared \n");
            }
            case "3" -> run();
            // Display error message if inputted value is incorrect
            default -> System.out.println("Invalid choice. Please enter again.");
        }
    }

    /**
     * Creates a receipt text file containing the details of the current order.
     * The receipt includes the items ordered, their prices, and the total price.
     * It also includes information about the store such as its name, address,
     * manager, and contact details.
     * The receipt file is saved with a timestamp in the file name.
     * After creating the receipt, it clears all items from the cart.
     */
    private void createReceipt() {
        // Get the current date
        Date currentDate = new Date();
        // Define the desired date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        // Format the current date
        String formattedDate = dateFormat.format(currentDate);
        // Declare a path to write receipt to
        String filePath = "/Users/butterflycoupe/Desktop/YearUp/DELIcious-sandwiches/DELIcious-sandwiches/DELIcious-sandwiches/Receipts/"
                + formattedDate + ".txt";

        // Try-catch block to handle writing to file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            // Write sandwich details
            writer.write("======================================\n");
            writer.write("              SANDWICHES              \n");
            writer.write("======================================\n");
            writer.newLine();
            // Check if the sandwich cart is not empty
            if (!sandwichCart.isEmpty()) {
                for (Sandwich sandwich : sandwichCart) {
                    writer.write(String.valueOf(sandwich));
                    writer.newLine();
                }
            } else {
                writer.write("No sandwiches Ordered\n");
                writer.newLine();
            }

            // Write drink details
            writer.write("\n======================================\n");
            writer.write("                DRINKS                \n");
            writer.write("======================================\n");
            writer.newLine();
            // Check if the drink cart is not empty
            if (!drinkCart.isEmpty()) {
                for (Drink drink : drinkCart) {
                    writer.write(String.valueOf(drink));
                    writer.newLine();
                }
            } else {
                writer.write("No Drinks Ordered\n");
                writer.newLine();
            }

            // Write chip details
            writer.write("\n======================================\n");
            writer.write("                CHIPS                 \n");
            writer.write("======================================\n");
            writer.newLine();
            // Check if the chip cart is not empty
            if (!chipCart.isEmpty()) {
                for (Chip chip : chipCart) {
                    writer.write(String.valueOf(chip));
                    writer.newLine();
                }
            } else {
                writer.write("No Chips Ordered\n");
                writer.newLine();
            }

            // Write chip details
            writer.write("\n======================================\n");
            writer.write("               COOKIES                 \n");
            writer.write("======================================\n");
            writer.newLine();
            // Check if the chip cart is not empty
            if (!cookieCart.isEmpty()) {
                for (Cookie cookie : cookieCart) {
                    writer.write(String.valueOf(cookie));
                    writer.newLine();
                }
            } else {
                writer.write("No Cookies Ordered\n");
                writer.newLine();
            }

            // Write total price
            String totalPriceLine = String.format("Total Price: $%.2f", totalPrice);
            int totalLength = totalPriceLine.length();
            int padding = (42 - totalLength) / 2; // Assuming the total line length is 42 characters
            String paddingStr = " ".repeat(padding);

            writer.write("\n==============================================\n");
            writer.write(paddingStr + totalPriceLine + paddingStr + "\n");
            writer.write("==============================================\n");

            // Write store information
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
            // Remove all items from cart after checkout
            clearCart();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Clears all items from the carts.
     */
    public void clearCart() {
        // Clear sandwich, drink, and chip carts
        sandwichCart.clear();
        drinkCart.clear();
        chipCart.clear();
        cookieCart.clear();
    }

    /**
     * Checks if any items are present in the carts.
     * If the carts are not empty, prompts the user to confirm their choices before
     * exiting.
     * If confirmed, clears the carts and returns to the home screen.
     * If not confirmed, allows the user to continue shopping.
     */
    private void exitBackHome() {
        // Check if any carts are not empty
        if (!sandwichCart.isEmpty() || !drinkCart.isEmpty() || !chipCart.isEmpty() || !cookieCart.isEmpty()) {
            while (true) {
                // Prompt user to confirm their choices
                System.out.println("\nBefore proceeding, would you like to confirm your choices?");
                System.out.println("Please note that this action will clear all items from your cart.");
                System.out.print("Confirm with 'Yes' or 'No': ");
                String userChoice = scanner.nextLine().trim();
                // Handle user input
                if (userChoice.equalsIgnoreCase("yes")) {
                    return; // Exit method if user confirms
                } else if (userChoice.equalsIgnoreCase("no")) {
                    run(); // Return to order screen if user declines
                    return;
                } else {
                    System.out.println("Invalid choice. Please enter 'Yes' or 'No'.");
                }
            }
        }
    }

    public static void playSound(String filePath) {
        try {
            File file = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }

}