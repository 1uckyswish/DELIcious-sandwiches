package com.pluralsight.userinterfaces;

import com.pluralsight.models.BLT;
import com.pluralsight.models.Philly;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.ToppingsManipulate;
import com.pluralsight.utilitymethods.UtilityMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The CreateSandwich class facilitates the creation of custom sandwiches by
 * providing
 * a user interface for selecting various sandwich options such as bread type,
 * size, toppings, etc.
 */
public class CreateSandwich {
    private static Scanner scanner;
    private final List<String> meatToppings = loadMeatToppings();
    private final List<String> cheeseToppings = loadCheeseToppings();
    private final List<String> regularToppings = loadRegularToppings();
    private final List<String> sauceOptions = loadSauceToppings();

    /**
     * Constructor for the CreateSandwich class.
     *
     * @param scanner Scanner object to read user input.
     */
    public CreateSandwich(Scanner scanner) {
        CreateSandwich.scanner = scanner;
    }

    /**
     * Method to create a new custom sandwich based on user input.
     *
     * @return The created sandwich object.
     */
    public Sandwich createSandwich() {
        Sandwich sandwich;
        String sandwichSize;
        String sandwichBread;
        boolean isToasted;
        System.out.println("\n======================================");
        System.out.println("|       Creating a New Sandwich     |");
        System.out.println("======================================\n");

        // Sandwich bread
        System.out.println("Select your bread type🍞");
        System.out.println("1️⃣ - White");
        System.out.println("2️⃣ - Wheat");
        System.out.println("3️⃣ - Rye");
        System.out.println("4️⃣ - Wrap");
        System.out.print("Enter your choice (1, 2, 3, 4): ");
        String breadChoice = UtilityMethods.takeBreadTypeInput(scanner, scanner.nextLine().trim(),
                "Enter your choice (1, 2, 3, 4): ");
        sandwichBread = (breadChoice.equals("1") ? "White"
                : breadChoice.equals("2") ? "Wheat" : breadChoice.equals("3") ? "Rye" : "Wrap");
        // Sandwich size
        System.out.println("\nWhat size sandwich would you like?");
        System.out.println("1️⃣ - 4-inch");
        System.out.println("2️⃣ - 8-inch");
        System.out.println("3️⃣ - 12-inch");
        System.out.print("Enter your choice (1, 2, 3): ");
        String sizeChoice = UtilityMethods.takeSizeInput(scanner, scanner.nextLine().trim(),
                "Enter your choice (1, 2, 3): ");
        sandwichSize = (sizeChoice.equals("1") ? "4" : sizeChoice.equals("2") ? "8" : "12");

        System.out.print("\nWould you like your sandwich toasted🥪? (Y/N): ");
        String toastChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "Would you like your sandwich toasted? (Y/N): ");
        isToasted = (toastChoice.equalsIgnoreCase("Y"));

        // Initialize a sandwich object with selected options
        sandwich = new Sandwich(sandwichSize, sandwichBread, isToasted);
        sandwich.setSizePrice((sandwichSize.equals("4") ? 5.50 : sandwichSize.equals("8") ? 7.00 : 8.50));
        // Set meat toppings

        setMeatToppingsAndBooleanValue(sandwich);
        // Set cheese toppings

        setCheeseToppingsAndBooleanValue(sandwich);
        // Set regular toppings

        setRegularToppings(sandwich);
        // Set sauce toppings

        setSaucesToppings(sandwich);
        // Additional option for Au Jus sauce

        System.out.print("Would you like a side of 4oz Au Jus Sauce🍲? (Y/N): ");
        String sideChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "Would you like a side of 4oz Au Jus Sauce🍲? (Y/N): ");
        if (sideChoice.equalsIgnoreCase("Y")) {
            sandwich.addRegularTopping("4oz Au Jus sauce");
        }
        // Calculate total price and display confirmation message

        sandwich.setPrice(sandwich.calculateTotalPrice());
        System.out.println("\n  🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪");
        System.out.println("    🥪   Sandwich Added   🥪");
        System.out.println("  🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪");

        return sandwich;

    }

    /**
     * Creates a customized signature sandwich based on the provided signature type.
     *
     * @param signature The type of signature sandwich to create (e.g., "BLT",
     *                  "Philly").
     * @return The customized signature sandwich instance.
     */
    public Sandwich customSignatureSandwich(String signature) {

        Sandwich sandwichInstance = null;

        // Instantiate a new sandwich object based on the provided signature
        if (signature.equalsIgnoreCase("BLT")) {
            sandwichInstance = new BLT();
        } else if (signature.equalsIgnoreCase("Philly")) {
            sandwichInstance = new Philly();
        }

        // Display customization options for the signature sandwich
        System.out.println("\n======================================");
        System.out.println("|       Customizing " + signature + " Sandwich     |");
        System.out.println("======================================\n");

        // Prompt user to change the bread type
        System.out.print("Would you like to change the bread type? (Y/N): ");
        String userBreadChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "Would you like to change the bread type? (Y/N): ");

        // Change a bread type based on user input
        if (userBreadChoice.equalsIgnoreCase("Y")) {
            System.out.println("Select your bread type🍞");
            System.out.println("1️⃣ - White");
            System.out.println("2️⃣ - Wheat");
            System.out.println("3️⃣ - Rye");
            System.out.println("4️⃣ - Wrap");
            System.out.print("Enter your choice (1, 2, 3, 4): ");
            String breadChoice = UtilityMethods.takeBreadTypeInput(scanner, scanner.nextLine().trim(),
                    "Enter your choice (1, 2, 3, 4): ");
            if (sandwichInstance != null) {
                sandwichInstance.setType(breadChoice.equals("1") ? "White"
                        : breadChoice.equals("2") ? "Wheat" : breadChoice.equals("3") ? "Rye" : "Wrap");
            }
        }

        // Prompt user to change the sandwich size
        System.out.print("Would you like to change the sandwich size? (Y/N): ");
        String userSizeChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "Would you like to change the sandwich size? (Y/N): ");
        if (userSizeChoice.equalsIgnoreCase("Y")) {
            System.out.println("\nWhat size sandwich would you like?");
            System.out.println("1️⃣ - 4-inch");
            System.out.println("2️⃣ - 8-inch");
            System.out.println("3️⃣ - 12-inch");
            System.out.print("Enter your choice (1, 2, 3): ");
            String sizeChoice = UtilityMethods.takeSizeInput(scanner, scanner.nextLine().trim(),
                    "Enter your choice (1, 2, 3): ");
            if (sandwichInstance != null) {
                sandwichInstance.setSize((sizeChoice.equals("1") ? "4" : sizeChoice.equals("2") ? "8" : "12"));
            }
            if (sandwichInstance != null) {
                sandwichInstance.setSizePrice((sandwichInstance.getSize().equals("4") ? 5.50
                        : sandwichInstance.getSize().equals("8") ? 7.00 : 8.50));
            }
        }

        // Prompt user to keep the sandwich toasted or not
        System.out.print("Would you like to keep the sandwich toasted? (Y/N): ");
        String userToastChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "Would you like to keep the sandwich toasted? (Y/N): ");
        if (userToastChoice.equalsIgnoreCase("N")) {
            if (sandwichInstance != null) {
                sandwichInstance.setToasted(false);
            }
        }

        // Set toppings for the signature sandwich
        setSignatureMeatToppingsAndBooleanValue((ToppingsManipulate) sandwichInstance);
        setSignatureCheeseToppingsAndBooleanValue((ToppingsManipulate) sandwichInstance);
        setSignatureRegularToppings((ToppingsManipulate) sandwichInstance);
        setSignatureSauceToppings((ToppingsManipulate) sandwichInstance);

        // Calculate the total price of the customized sandwich
        if (sandwichInstance != null) {
            sandwichInstance.setPrice(sandwichInstance.calculateTotalPrice());
        }

        return sandwichInstance;
    }

    /**
     * Sets the sauce toppings for the signature sandwich.
     *
     * @param sandwich The signature sandwich instance to customize.
     */
    private void setSignatureSauceToppings(ToppingsManipulate sandwich) {
        Sandwich sandwichInstance = null;

        // Cast the sandwich instance to the appropriate subclass (BLT or Philly)
        if (sandwich instanceof BLT) {
            sandwichInstance = (BLT) sandwich;
        } else if (sandwich instanceof Philly) {
            sandwichInstance = (Philly) sandwich;
        }

        List<String> selectedSauceToppings = new ArrayList<>();
        boolean addMoreSauces;
        boolean saucesSelected = false;

        // Prompt the user to remove any current sauce topping
        System.out.print("Would you like to remove the current sauce topping? (Y/N): ");
        String userRemoveSauceToppingChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "Would you like to remove any of the current sauce topping? (Y/N): ");
        if (userRemoveSauceToppingChoice.equalsIgnoreCase("Y")) {
            // Remove the specified sauce topping based on the sandwich type
            if (sandwichInstance instanceof BLT) {
                ((BLT) sandwichInstance).removeRegularTopping("Ranch");
                System.out.println("\n~~ Ranch Sauce Removed ~~");
            } else if (sandwichInstance instanceof Philly) {
                ((Philly) sandwichInstance).removeRegularTopping("Mayo");
                System.out.println("\n~~ Mayo Sauce Removed ~~");
            }
        }

        // Prompt the user to add sauce to the sandwich
        System.out.print("\nWould you like sauce added to your sandwich🧂? (Y/N): ");
        String sauceChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "\nWould you like sauce added to your sandwich🧂? (Y/N): ");

        if (sauceChoice.equalsIgnoreCase("Y")) {
            saucesSelected = true;

            // Loop for selecting sauces
            do {
                String selectedSauce = UtilityMethods.validateToppingsChoice(scanner, sauceOptions);
                selectedSauceToppings.add(selectedSauce);

                // Prompt the user if they want to add more sauces
                System.out.print("\nWould you like additional sauces added🧂? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                        "\nWould you like additional sauces added🧂? (Y/N): ");
                addMoreSauces = (repeatChoice.equalsIgnoreCase("Y"));
            } while (addMoreSauces); // Continue looping if user wants more sauces
        }

        // Add selected sauces to the sandwich if any sauces are selected
        if (saucesSelected) {
            for (String topping : selectedSauceToppings) {
                sandwichInstance.addRegularTopping(topping);
            }
        }
    }

    /**
     * Sets the regular toppings for the signature sandwich.
     *
     * @param sandwich The signature sandwich instance to customize.
     */
    private void setSignatureRegularToppings(ToppingsManipulate sandwich) {
        Sandwich sandwichInstance = null;

        // Cast the sandwich instance to the appropriate subclass (BLT or Philly)
        if (sandwich instanceof BLT) {
            sandwichInstance = (BLT) sandwich;
        } else if (sandwich instanceof Philly) {
            sandwichInstance = (Philly) sandwich;
        }

        List<String> selectedRegularToppings = new ArrayList<>();
        boolean addMoreToppings;
        boolean toppingsSelected = false;

        // Prompt the user to remove any current veggie topping
        System.out.print("Would you like to remove the current veggie topping? (Y/N): ");
        String userRemoveVeggieToppingChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "Would you like to remove any of the current veggie topping? (Y/N): ");
        if (userRemoveVeggieToppingChoice.equalsIgnoreCase("Y")) {
            // Remove the specified veggie topping based on the sandwich type
            if (sandwichInstance instanceof BLT) {
                ((BLT) sandwichInstance).removeRegularTopping("Lettuce");
                ((BLT) sandwichInstance).removeRegularTopping("Tomato");
                System.out.println("\n~~ Lettuce & Tomato Removed ~~");
            } else if (sandwichInstance instanceof Philly) {
                ((Philly) sandwichInstance).removeRegularTopping("Peppers");
                System.out.println("\n~~ Peppers Removed ~~");
            }
        }

        // Prompt the user to add veggie toppings to the sandwich
        System.out.print("\nWould you like veggie toppings in your sandwich🥗? (Y/N): ");
        String toppingsChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "\nWould you like veggie toppings in your sandwich🥗? (Y/N): ");

        if (toppingsChoice.equalsIgnoreCase("Y")) {
            toppingsSelected = true;

            // Loop for selecting veggie toppings
            do {
                String selectedToppings = UtilityMethods.validateToppingsChoice(scanner, regularToppings);
                selectedRegularToppings.add(selectedToppings);

                // Prompt the user if they want to add more veggie toppings
                System.out.print("\nWould you like additional veggie toppings🥒? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                        "\nWould you like additional veggie toppings🧅? (Y/N): ");
                addMoreToppings = repeatChoice.equalsIgnoreCase("Y");

            } while (addMoreToppings); // Continue looping if user wants more toppings
        }

        // Add selected veggie toppings to the sandwich if any are selected
        if (toppingsSelected) {
            for (String topping : selectedRegularToppings) {
                sandwichInstance.addRegularTopping(topping);
            }
        }
    }

    /**
     * Sets the premium meat toppings for the signature sandwich and updates boolean
     * values accordingly.
     *
     * @param sandwich The signature sandwich instance to customize.
     */
    private void setSignatureMeatToppingsAndBooleanValue(ToppingsManipulate sandwich) {
        Sandwich sandwichInstance = null;

        // Cast the sandwich instance to the appropriate subclass (BLT or Philly)
        if (sandwich instanceof BLT) {
            sandwichInstance = (BLT) sandwich;
        } else if (sandwich instanceof Philly) {
            sandwichInstance = (Philly) sandwich;
        }

        List<String> selectedMeats = new ArrayList<>();
        boolean addMoreMeat; // Initialize addMoreMeat flag
        boolean meatSelected = false; // Track if meat is selected

        // Prompt the user to remove any current meat topping
        System.out.print("Would you like to remove any of the current meat topping? (Y/N): ");
        String userRemoveMeatToppingChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "Would you like to remove any of the current topping? (Y/N): ");
        if (userRemoveMeatToppingChoice.equalsIgnoreCase("Y")) {
            // Remove the specified meat topping based on the sandwich type
            if (sandwichInstance instanceof BLT) {
                ((BLT) sandwichInstance).removePremiumTopping("Bacon");
                sandwichInstance.setHasMeat(false);
                sandwichInstance.setMeatPrice(0.00);
                System.out.println("\n ~~ Bacon Removed ~~ ");
            } else if (sandwichInstance instanceof Philly) {
                ((Philly) sandwichInstance).removePremiumTopping("Steak");
                sandwichInstance.setHasMeat(false);
                sandwichInstance.setMeatPrice(0.00);
                System.out.println("\n ~~ Steak Removed ~~");
            }
        }

        // Prompt the user to add meat to the sandwich
        System.out.print("\nWould you like meat in your sandwich🍖? (Y/N): ");
        String meatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "\nWould you like meat in your sandwich🍖? (Y/N): ");

        if (meatChoice.equalsIgnoreCase("Y")) {
            // Set meat-related boolean values and calculate the initial meat price
            sandwichInstance.setHasMeat(true);
            sandwichInstance.setMeatPrice(sandwichInstance.getSize().equals("4") ? 1.00
                    : sandwichInstance.getSize().equals("8") ? 2.00 : 3.00);
            meatSelected = true;

            // Loop for selecting meat
            do {
                String selectedMeat = UtilityMethods.validateMeatChoice(scanner, meatToppings);
                selectedMeats.add(selectedMeat);

                // Prompt the user if they want to add more meat toppings
                System.out.print("\nWould you like more meat on your sandwich🥩? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                        "Would you like more meat on your sandwich🥩? (Y/N): ");
                addMoreMeat = repeatChoice.equalsIgnoreCase("Y");

                // Set extra meat flag based on user choice
                sandwichInstance.setExtraMeat(addMoreMeat);

            } while (addMoreMeat); // Continue looping if user wants more meat
        }

        // Add selected meat toppings to the sandwich if meat is selected
        if (meatSelected) {
            for (String meat : selectedMeats) {
                sandwichInstance.addPremiumTopping(meat);
            }
        }

        // Calculate the total cost of extra meat toppings
        int extraMeatCount = selectedMeats.size() - 1; // Exclude the first meat, which is included in the base price
        double extraMeatCost = 0.0;
        if (sandwichInstance != null) {
            switch (sandwichInstance.getSize()) {
                case "4":
                    extraMeatCost = 0.50 * extraMeatCount;
                    break;
                case "8":
                    extraMeatCost = 1.00 * extraMeatCount;
                    break;
                case "12":
                    extraMeatCost = 1.50 * extraMeatCount;
                    break;
                default:
                    break;
            }
        }

        // Set extra meat flag and update the total cost of the sandwich
        if (selectedMeats.size() > 1 && sandwichInstance != null) {
            sandwichInstance.setExtraMeat(true);
        }
        if (sandwichInstance != null) {
            sandwichInstance.setExtraMeatPrice(extraMeatCost);
        }
    }

    /**
     * Sets the premium cheese toppings for the signature sandwich and updates
     * boolean values accordingly.
     *
     * @param sandwich The signature sandwich instance to customize.
     */
    private void setSignatureCheeseToppingsAndBooleanValue(ToppingsManipulate sandwich) {
        Sandwich sandwichInstance = null;

        // Cast the sandwich instance to the appropriate subclass (BLT or Philly)
        if (sandwich instanceof BLT) {
            sandwichInstance = (BLT) sandwich;
        } else if (sandwich instanceof Philly) {
            sandwichInstance = (Philly) sandwich;
        }

        List<String> selectedCheeses = new ArrayList<>();
        boolean addMoreCheese; // Initialize addMoreCheese flag
        boolean cheeseSelected = false; // Track if cheese is selected

        // Prompt the user to remove any current cheese topping
        System.out.print("Would you like to remove any of the current cheese topping? (Y/N): ");
        String userRemoveCheeseToppingChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "Would you like to remove any of the current cheese topping? (Y/N): ");
        if (userRemoveCheeseToppingChoice.equalsIgnoreCase("Y")) {
            // Remove the specified cheese topping based on the sandwich type
            if (sandwichInstance instanceof BLT) {
                ((BLT) sandwichInstance).removePremiumTopping("Cheddar");
                sandwichInstance.setHasCheese(false);
                sandwichInstance.setCheesePrice(0.00);
                System.out.println("\n ~~ Cheddar Cheese Removed ~~");
            } else if (sandwichInstance instanceof Philly) {
                ((Philly) sandwichInstance).removePremiumTopping("American");
                sandwichInstance.setHasCheese(false);
                sandwichInstance.setCheesePrice(0.00);
                System.out.println("\n ~~ American Cheese Removed ~~");
            }
        }

        // Prompt the user to add cheese to the sandwich
        System.out.print("\nWould you like Cheese in your sandwich🧀? (Y/N): ");
        String cheeseChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "\nWould you like Cheese in your sandwich🧀? (Y/N): ");

        if (cheeseChoice.equalsIgnoreCase("Y")) {
            // Set cheese-related boolean values and calculate the initial cheese price
            sandwichInstance.setHasCheese(true);
            sandwichInstance.setCheesePrice(sandwichInstance.getSize().equals("4") ? 1.00
                    : sandwichInstance.getSize().equals("8") ? 2.00 : 3.00);
            cheeseSelected = true;

            // Loop for selecting cheese
            do {
                String selectedCheese = UtilityMethods.validateCheeseChoice(scanner, cheeseToppings);
                selectedCheeses.add(selectedCheese);

                // Prompt the user if they want to add more cheese toppings
                System.out.print("\nWould you like more Cheese on your sandwich🧀? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                        "Would you like more Cheese on your sandwich🧀? (Y/N): ");
                addMoreCheese = repeatChoice.equalsIgnoreCase("Y");

                // Set extra cheese flag based on user choice
                sandwichInstance.setExtraCheese(addMoreCheese);

            } while (addMoreCheese); // Continue looping if user wants more cheese
        }

        // Add selected cheese toppings to the sandwich if cheese is selected
        if (cheeseSelected) {
            for (String cheese : selectedCheeses) {
                sandwichInstance.addPremiumTopping(cheese);
            }
        }

        // Calculate the total cost of extra cheese toppings
        int extraCheeseCount = selectedCheeses.size() - 1; // Exclude the first cheese, which is included in the base
        // price
        double extraCheeseCost = 0.0;
        if (sandwichInstance != null) {
            switch (sandwichInstance.getSize()) {
                case "4":
                    extraCheeseCost = 0.30 * extraCheeseCount;
                    break;
                case "8":
                    extraCheeseCost = 0.60 * extraCheeseCount;
                    break;
                case "12":
                    extraCheeseCost = 0.90 * extraCheeseCount;
                    break;
                default:
                    break;
            }
        }

        // Set extra cheese flag and update the total cost of the sandwich
        if (selectedCheeses.size() > 1 && sandwichInstance != null) {
            sandwichInstance.setExtraCheese(true);
        }
        if (sandwichInstance != null) {
            sandwichInstance.setExtraCheesePrice(extraCheeseCost);
        }
    }

    /**
     * Sets the meat toppings and updates boolean values accordingly for the given
     * sandwich.
     *
     * @param sandwich The sandwich instance to customize with meat toppings.
     */
    private void setMeatToppingsAndBooleanValue(Sandwich sandwich) {
        List<String> selectedMeats = new ArrayList<>();
        boolean addMoreMeat; // Flag to track if more meat is to be added
        boolean meatSelected = false; // Flag to indicate if meat is selected

        // Prompt the user to add meat to the sandwich
        System.out.print("\nWould you like meat in your sandwich🍖? (Y/N): ");
        String meatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "\nWould you like meat in your sandwich🍖? (Y/N): ");

        if (meatChoice.equalsIgnoreCase("Y")) {
            // Set meat-related boolean values and calculate the initial meat price
            sandwich.setHasMeat(true);
            sandwich.setMeatPrice(sandwich.getSize().equals("4") ? 1.00 : sandwich.getSize().equals("8") ? 2.00 : 3.00);
            meatSelected = true;

            // Loop for selecting meat toppings
            do {
                String selectedMeat = UtilityMethods.validateMeatChoice(scanner, meatToppings);
                selectedMeats.add(selectedMeat);

                // Prompt the user if they want to add more meat toppings
                System.out.print("\nWould you like more meat on your sandwich🥩? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                        "Would you like more meat on your sandwich🥩? (Y/N): ");
                addMoreMeat = repeatChoice.equalsIgnoreCase("Y");

                // Set extra meat flag based on user choice
                sandwich.setExtraMeat(addMoreMeat);

            } while (addMoreMeat); // Continue looping if user wants more meat

            // Add selected meats to the sandwich if meat is selected
            if (meatSelected) {
                for (String meat : selectedMeats) {
                    sandwich.addPremiumTopping(meat);
                }

                // Calculate the total cost of extra meat toppings
                int extraMeatCount = selectedMeats.size() - 1; // Exclude the first meat, which is included in the base
                // price
                double extraMeatCost = 0.0;
                switch (sandwich.getSize()) {
                    case "4":
                        extraMeatCost = 0.50 * extraMeatCount;
                        break;
                    case "8":
                        extraMeatCost = 1.00 * extraMeatCount;
                        break;
                    case "12":
                        extraMeatCost = 1.50 * extraMeatCount;
                        break;
                    default:
                        break;
                }

                // Set extra meat flag and update the total cost of the sandwich
                if (selectedMeats.size() > 1) {
                    sandwich.setExtraMeat(true);
                }
                sandwich.setExtraMeatPrice(extraMeatCost);
            }
        }
    }

    /**
     * Sets the cheese toppings and updates boolean values accordingly for the given
     * sandwich.
     *
     * @param sandwich The sandwich instance to customize with cheese toppings.
     */
    private void setCheeseToppingsAndBooleanValue(Sandwich sandwich) {
        List<String> selectedCheeses = new ArrayList<>();
        boolean addMoreCheese; // Flag to track if more cheese is to be added
        boolean cheeseSelected = false; // Flag to indicate if cheese is selected

        // Prompt the user to add cheese to the sandwich
        System.out.print("\nWould you like cheese in your sandwich🧀? (Y/N): ");
        String cheeseChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "\nWould you like cheese in your sandwich🧀? (Y/N): ");

        if (cheeseChoice.equalsIgnoreCase("Y")) {
            // Set cheese-related boolean values and calculate the initial cheese price
            sandwich.setHasCheese(true);
            sandwich.setCheesePrice(
                    sandwich.getSize().equals("4") ? 0.75 : sandwich.getSize().equals("8") ? 1.50 : 2.25);
            cheeseSelected = true;

            // Loop for selecting cheese toppings
            do {
                String selectedCheese = UtilityMethods.validateCheeseChoice(scanner, cheeseToppings);
                selectedCheeses.add(selectedCheese);

                // Prompt the user if they want to add more cheese toppings
                System.out.print("\nWould you like more cheese on your sandwich🧀? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                        "\nWould you like more cheese on your sandwich🧀? (Y/N): ");
                addMoreCheese = repeatChoice.equalsIgnoreCase("Y");

            } while (addMoreCheese); // Continue looping if user wants more cheese

            // Add selected cheeses to the sandwich if cheese is selected
            if (cheeseSelected) {
                for (String cheese : selectedCheeses) {
                    sandwich.addPremiumTopping(cheese);
                }

                // Calculate the total cost of extra cheese toppings
                int extraCheeseCount = selectedCheeses.size() - 1; // Exclude the first cheese, which is included in the
                // base price
                double extraCheeseCost = 0.0;
                switch (sandwich.getSize()) {
                    case "4":
                        extraCheeseCost = 0.30 * extraCheeseCount;
                        break;
                    case "8":
                        extraCheeseCost = 0.60 * extraCheeseCount;
                        break;
                    case "12":
                        extraCheeseCost = 0.90 * extraCheeseCount;
                        break;
                    default:
                        break;
                }

                // Set extra cheese flag and update the total cost of the sandwich
                if (selectedCheeses.size() > 1) {
                    sandwich.setExtraCheese(true);
                }
                sandwich.setExtraCheesePrice(extraCheeseCost);
            }
        }
    }

    /**
     * Sets the regular (vegetable) toppings for the given sandwich based on user
     * input.
     *
     * @param sandwich The sandwich instance to customize with regular toppings.
     */
    private void setRegularToppings(Sandwich sandwich) {
        List<String> selectedRegularToppings = new ArrayList<>();
        boolean addMoreToppings; // Flag to track if more toppings are to be added
        boolean toppingsSelected = false; // Flag to indicate if toppings are selected

        // Prompt the user to add vegetable toppings to the sandwich
        System.out.print("\nWould you like veggie toppings in your sandwich🥗? (Y/N): ");
        String toppingsChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "\nWould you like veggie toppings in your sandwich🥗? (Y/N): ");

        if (toppingsChoice.equalsIgnoreCase("Y")) {
            toppingsSelected = true;

            // Loop for selecting vegetable toppings
            do {
                String selectedToppings = UtilityMethods.validateToppingsChoice(scanner, regularToppings);
                selectedRegularToppings.add(selectedToppings);

                // Prompt the user if they want to add more vegetable toppings
                System.out.print("\nWould you like additional veggie toppings🥒? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                        "\nWould you like additional veggie toppings🧅? (Y/N): ");
                addMoreToppings = repeatChoice.equalsIgnoreCase("Y");

            } while (addMoreToppings); // Continue looping if user wants more toppings
        }

        // Add selected vegetable toppings to the sandwich if toppings are selected
        if (toppingsSelected) {
            for (String topping : selectedRegularToppings) {
                sandwich.addRegularTopping(topping);
            }
        }
    }

    /**
     * Sets the sauce toppings for the given sandwich based on user input.
     *
     * @param sandwich The sandwich instance to customize with sauce toppings.
     */
    private void setSaucesToppings(Sandwich sandwich) {
        List<String> selectedSauceToppings = new ArrayList<>();
        boolean addMoreSauces; // Flag to track if more sauces are to be added
        boolean saucesSelected = false; // Flag to indicate if sauces are selected

        // Prompt the user to add sauce toppings to the sandwich
        System.out.print("\nWould you like sauce added to your sandwich🧂? (Y/N): ");
        String sauceChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                "\nWould you like sauce added to your sandwich🧂? (Y/N): ");

        if (sauceChoice.equalsIgnoreCase("Y")) {
            saucesSelected = true;

            // Loop for selecting sauce toppings
            do {
                String selectedSauces = UtilityMethods.validateToppingsChoice(scanner, sauceOptions);
                selectedSauceToppings.add(selectedSauces);

                // Prompt the user if they want to add more sauce toppings
                System.out.print("\nWould you like additional sauces added🧂? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(),
                        "\nWould you like additional sauces added🧂? (Y/N): ");
                addMoreSauces = repeatChoice.equalsIgnoreCase("Y");

            } while (addMoreSauces); // Continue looping if user wants more toppings
        }

        // Add selected sauce toppings to the sandwich if sauces are selected
        if (saucesSelected) {
            for (String sauce : selectedSauceToppings) {
                sandwich.addRegularTopping(sauce);
            }
        }
    }

    /**
     * Loads a list of meat toppings available for sandwiches.
     *
     * @return A list of meat toppings.
     */
    private List<String> loadMeatToppings() {
        List<String> meatToppings = new ArrayList<>();
        // Add various meat toppings to the list
        meatToppings.add("Roast Beef");
        meatToppings.add("Chicken");
        meatToppings.add("Salami");
        meatToppings.add("Steak");
        meatToppings.add("Bacon");
        meatToppings.add("Ham");
        return meatToppings;
    }

    /**
     * Loads a list of cheese toppings available for sandwiches.
     *
     * @return A list of cheese toppings.
     */
    private List<String> loadCheeseToppings() {
        List<String> cheeseToppings = new ArrayList<>();
        // Add various cheese toppings to the list
        cheeseToppings.add("Provolone");
        cheeseToppings.add("American");
        cheeseToppings.add("Cheddar");
        cheeseToppings.add("Swiss");
        return cheeseToppings;
    }

    /**
     * Loads a list of regular toppings available for sandwiches.
     *
     * @return A list of regular toppings.
     */
    private List<String> loadRegularToppings() {
        List<String> regularToppings = new ArrayList<>();
        // Add various regular toppings to the list
        regularToppings.add("Jalapenos");
        regularToppings.add("Guacamole");
        regularToppings.add("Cucumbers");
        regularToppings.add("Mushrooms");
        regularToppings.add("Tomatoes");
        regularToppings.add("Peppers");
        regularToppings.add("Lettuce");
        regularToppings.add("Pickles");
        regularToppings.add("Onions");
        return regularToppings;
    }

    /**
     * Loads a list of sauce toppings available for sandwiches.
     *
     * @return A list of sauce toppings.
     */
    private List<String> loadSauceToppings() {
        List<String> sauceToppings = new ArrayList<>();
        // Add various sauce toppings to the list
        sauceToppings.add("Thousand Island");
        sauceToppings.add("Vinaigrette");
        sauceToppings.add("Mustard");
        sauceToppings.add("Ketchup");
        sauceToppings.add("Ranch");
        sauceToppings.add("Mayo");
        return sauceToppings;
    }

}
