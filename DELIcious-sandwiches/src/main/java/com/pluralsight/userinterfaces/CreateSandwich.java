package com.pluralsight.userinterfaces;
import com.pluralsight.models.BLT;
import com.pluralsight.models.Philly;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.ToppingsManipulable;
import com.pluralsight.utilitymethods.UtilityMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateSandwich {
    private static Scanner scanner;
    private final List<String> meatToppings = loadMeatToppings();
    private final List<String> cheeseToppings = loadCheeseToppings();
    private final List<String> regularToppings = loadRegularToppings();
    private final List<String> sauceOptions = loadSauceToppings();

    public CreateSandwich(Scanner scanner) {
        this.scanner = scanner;
    }

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
        String breadChoice = UtilityMethods.takeBreadTypeInput(scanner, scanner.nextLine().trim(), "Enter your choice (1, 2, 3, 4): ");
        sandwichBread = (breadChoice.equals("1") ? "White" : breadChoice.equals("2") ? "Wheat" : breadChoice.equals("3") ? "Rye" : "Wrap");
// Sandwich size
        System.out.println("\nWhat size sandwich would you like?");
        System.out.println("1️⃣ - 4-inch");
        System.out.println("2️⃣ - 8-inch");
        System.out.println("3️⃣ - 12-inch");
        System.out.print("Enter your choice (1, 2, 3): ");
        String sizeChoice = UtilityMethods.takeSizeInput(scanner, scanner.nextLine().trim(), "Enter your choice (1, 2, 3): ");
        sandwichSize = (sizeChoice.equals("1") ? "4" : sizeChoice.equals("2") ? "8" : "12");

        System.out.print("\nWould you like your sandwich toasted🥪? (Y/N): ");
        String toastChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like your sandwich toasted? (Y/N): ");
        isToasted = (toastChoice.equalsIgnoreCase("Y"));

//Make new object to access methods
        sandwich = new Sandwich(sandwichSize, sandwichBread, isToasted);
        sandwich.setSizePrice((sandwichSize.equals("4") ? 5.50 : sandwichSize.equals("8") ? 7.00 : 8.50));
        setMeatToppingsAndBooleanValue(sandwich);
        setCheeseToppingsAndBooleanValue(sandwich);
        setRegularToppings(sandwich);
        setSaucesToppings(sandwich);

        System.out.print("Would you like a side of 4oz Au Jus Sauce🍲? (Y/N): ");
        String sideChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like a side of 4oz Au Jus Sauce🍲? (Y/N): ");
        if (sideChoice.equalsIgnoreCase("Y")){
            sandwich.addRegularTopping("4oz Au Jus sauce");
        }

        sandwich.setPrice(sandwich.calculateTotalPrice());
        System.out.println("\n  🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪");
        System.out.println("    🥪   Sandwich Added   🥪");
        System.out.println("  🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪🥪");

        return sandwich;

    }



    public Sandwich customSignatureSandwich(String signature){

        Sandwich sandwichInstance = null;

        if (signature.equalsIgnoreCase("BLT")) {
            sandwichInstance = new BLT(); // Instantiate a new BLT object
        } else if (signature.equalsIgnoreCase("Philly")) {
            sandwichInstance = new Philly(); // Instantiate a new Philly object
        }


        System.out.println("\n======================================");
        System.out.println("|       Customizing "+signature+" Sandwich     |");
        System.out.println("======================================\n");

        System.out.print("Would you like to change bread type? (Y/N):");
        String userBreadChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like to change bread type? (Y/N):");

        if (userBreadChoice.equalsIgnoreCase("Y")) {
            System.out.println("Select your bread type🍞");
            System.out.println("1️⃣ - White");
            System.out.println("2️⃣ - Wheat");
            System.out.println("3️⃣ - Rye");
            System.out.println("4️⃣ - Wrap");
            System.out.print("Enter your choice (1, 2, 3, 4): ");
            String breadChoice = UtilityMethods.takeBreadTypeInput(scanner, scanner.nextLine().trim(), "Enter your choice (1, 2, 3, 4): ");
            sandwichInstance.setType(breadChoice.equals("1") ? "White" : breadChoice.equals("2") ? "Wheat" : breadChoice.equals("3") ? "Rye" : "Wrap");
        }

        System.out.print("Would you like to change Sandwich size? (Y/N):");
        String userSizeChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like to change Sandwich size? (Y/N):");
        if(userSizeChoice.equalsIgnoreCase("Y")){
            System.out.println("\nWhat size sandwich would you like?");
            System.out.println("1️⃣ - 4-inch");
            System.out.println("2️⃣ - 8-inch");
            System.out.println("3️⃣ - 12-inch");
            System.out.print("Enter your choice (1, 2, 3): ");
            String sizeChoice = UtilityMethods.takeSizeInput(scanner, scanner.nextLine().trim(), "Enter your choice (1, 2, 3): ");
            sandwichInstance.setSize((sizeChoice.equals("1") ? "4" : sizeChoice.equals("2") ? "8" : "12"));
            sandwichInstance.setSizePrice((sandwichInstance.getSize().equals("4") ? 5.50 : sandwichInstance.getSize().equals("8") ? 7.00 : 8.50));
        }



        System.out.print("Would you like to keep the sandwich Toasted? (Y/N): ");
        String userToastChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like to keep the sandwich Toasted? (Y/N):");
        if (userToastChoice.equalsIgnoreCase("N")){
            sandwichInstance.setToasted(false);
        }

        setSignatureMeatToppingsAndBooleanValue((ToppingsManipulable) sandwichInstance);
        setSignatureCheeseToppingsAndBooleanValue((ToppingsManipulable) sandwichInstance);
        setSignatureRegularToppings((ToppingsManipulable) sandwichInstance);
        setSignatureSauceToppings((ToppingsManipulable) sandwichInstance);
        sandwichInstance.setPrice(sandwichInstance.calculateTotalPrice());

        return sandwichInstance;
    }

    private void setSignatureSauceToppings(ToppingsManipulable sandwich) {
        Sandwich sandwichInstance = null;

        if (sandwich instanceof BLT) {
            sandwichInstance = (BLT) sandwich;
        } else if (sandwich instanceof Philly) {
            sandwichInstance = (Philly) sandwich;
        }

        List<String> selectedSauceToppings = new ArrayList<>();
        boolean addMoreSauces = false;
        boolean saucesSelected = false;

        System.out.print("Would you like to remove the current sauce topping? (Y/N): ");
        String userRemoveSauceToppingChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like to remove any of the current sauce topping? (Y/N): ");
        if (userRemoveSauceToppingChoice.equalsIgnoreCase("Y")) {
            if (sandwichInstance instanceof BLT) {
                ((BLT) sandwichInstance).removeRegularTopping("Ranch");
                System.out.println("\n~~ Ranch Sauce Removed ~~");
            } else if (sandwichInstance instanceof Philly) {
                ((Philly) sandwichInstance).removeRegularTopping("Mayo");
                System.out.println("\n~~ Mayo Sauce Removed ~~");
            }
        }

        System.out.print("\nWould you like sauce added to your sandwich🧂? (Y/N): ");
        String sauceChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like sauce added to your sandwich🧂? (Y/N): ");

        if (sauceChoice.equalsIgnoreCase("Y")) {
            saucesSelected = true;

            // Loop for selecting sauces
            do {
                String selectedSauce = UtilityMethods.validateToppingsChoice(scanner, sauceOptions);
                selectedSauceToppings.add(selectedSauce);

                System.out.print("\nWould you like additional sauces added🧂? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like additional sauces added🧂? (Y/N): ");
                addMoreSauces = (repeatChoice.equalsIgnoreCase("Y") ? true : false);
            } while (addMoreSauces); // Continue looping if user wants more sauces
        }

        // Add selected sauces to the sandwich if any sauces are selected

        if (saucesSelected) {
            for (String topping : selectedSauceToppings) {
                if (sandwichInstance instanceof BLT) {
                    ((BLT) sandwichInstance).addRegularTopping(topping);
                } else if (sandwichInstance instanceof Philly) {
                    ((Philly) sandwichInstance).addRegularTopping(topping);
                }
            }
        }
    }

    private void setSignatureRegularToppings(ToppingsManipulable sandwich){
        Sandwich sandwichInstance = null;

        if (sandwich instanceof BLT) {
            sandwichInstance = (BLT) sandwich;
        } else if (sandwich instanceof Philly) {
            sandwichInstance = (Philly) sandwich;
        }

        List<String> selectedRegularToppings = new ArrayList<>();
        boolean addMoreToppings = false;
        boolean toppingsSelected = false;

        System.out.print("Would you like to remove the current veggie topping? (Y/N): ");
        String userRemoveVeggieToppingChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like to remove any of the current veggie topping? (Y/N): ");
        if(userRemoveVeggieToppingChoice.equalsIgnoreCase("Y")){
            if (sandwichInstance instanceof BLT) {
                ((BLT) sandwichInstance).removeRegularTopping("Lettuce");
                ((BLT) sandwichInstance).removeRegularTopping("Tomato");
                System.out.println("\n~~ Lettuce & Tomato Removed ~~");
            } else if (sandwichInstance instanceof Philly) {
                ((Philly) sandwichInstance).removeRegularTopping("Peppers");
                System.out.println("\n~~ Peppers Removed ~~");
            }
        }


        System.out.print("\nWould you like veggie toppings in your sandwich🥗? (Y/N): ");
        String toppingsChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like veggie toppings in your sandwich🥗? (Y/N): ");

        if (toppingsChoice.equalsIgnoreCase("Y")) {
            toppingsSelected = true;

            // Loop for selecting meat
            do {
                String selectedToppings = UtilityMethods.validateToppingsChoice(scanner, regularToppings);
                selectedRegularToppings.add(selectedToppings);

                System.out.print("\nWould you like additional veggie toppings🥒? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like additional veggie toppings🧅? (Y/N): ");
                addMoreToppings = repeatChoice.equalsIgnoreCase("Y");


            } while (addMoreToppings); // Continue looping if user wants more toppings
        }

        // Add selected meats to the sandwich if meat is selected
        if (toppingsSelected) {
            for (String topping : selectedRegularToppings) {
                if (sandwichInstance instanceof BLT) {
                    ((BLT) sandwichInstance).addRegularTopping(topping);
                } else if (sandwichInstance instanceof Philly) {
                    ((Philly) sandwichInstance).addRegularTopping(topping);
                }
            }
        }

    }

    private void setSignatureMeatToppingsAndBooleanValue(ToppingsManipulable sandwich) {
        Sandwich sandwichInstance = null;

        if (sandwich instanceof BLT) {
            sandwichInstance = (BLT) sandwich;
        } else if (sandwich instanceof Philly) {
            sandwichInstance = (Philly) sandwich;
        }

        List<String> selectedMeats = new ArrayList<>();
        boolean addMoreMeat = false; // Initialize addMoreMeat
        boolean meatSelected = false; // Track if meat is selected

        System.out.print("Would you like to remove any of the current meat topping? (Y/N): ");
        String userRemoveMeatToppingChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like to remove any of the current topping? (Y/N): ");
        if(userRemoveMeatToppingChoice.equalsIgnoreCase("Y")){
            if (sandwichInstance instanceof BLT) {
                ((BLT) sandwichInstance).removePremiumTopping("Bacon");
                ((BLT) sandwichInstance).setHasMeat(false);
                ((BLT) sandwichInstance).setMeatPrice(0.00);
                System.out.println("\n ~~ Bacon Removed ~~ ");
            } else if (sandwichInstance instanceof Philly) {
                ((Philly) sandwichInstance).removePremiumTopping("Steak");
                ((Philly) sandwichInstance).setHasMeat(false);
                ((Philly) sandwichInstance).setMeatPrice(0.00);
                System.out.println("\n ~~ Steak Removed ~~");
            }
        }


        System.out.print("\nWould you like meat in your sandwich🍖? (Y/N): ");
        String meatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like meat in your sandwich🍖? (Y/N): ");

        if (meatChoice.equalsIgnoreCase("Y")) {
            if (sandwichInstance instanceof BLT) {
                ((BLT) sandwichInstance).setHasMeat(true);
                ((BLT) sandwichInstance).setMeatPrice(((BLT) sandwichInstance).getSize().equals("4") ? 1.00 : ((BLT) sandwichInstance).getSize().equals("8") ? 2.00 : 3.00);
                meatSelected = true;
            } else if (sandwichInstance instanceof Philly) {
                ((Philly) sandwichInstance).setHasMeat(true);
                ((Philly) sandwichInstance).setMeatPrice(((Philly) sandwichInstance).getSize().equals("4") ? 1.00 : ((Philly) sandwichInstance).getSize().equals("8") ? 2.00 : 3.00);
            }

            // Loop for selecting meat
            do {
                String selectedMeat = UtilityMethods.validateMeatChoice(scanner, meatToppings);
                selectedMeats.add(selectedMeat);

                System.out.print("\nWould you like more meat on your sandwich🥩? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like more meat on your sandwich🥩? (Y/N): ");
                addMoreMeat = repeatChoice.equalsIgnoreCase("Y");

                // Set extra meat flag based on user choice
                if (addMoreMeat) {
                    if (sandwichInstance instanceof BLT) {
                        ((BLT) sandwichInstance).setExtraMeat(true);
                    } else if (sandwichInstance instanceof Philly) {
                        ((Philly) sandwichInstance).setExtraMeat(true);
                    }
                } else {
                    if (sandwichInstance instanceof BLT) {
                        ((BLT) sandwichInstance).setExtraMeat(false);
                    } else if (sandwichInstance instanceof Philly) {
                        ((Philly) sandwichInstance).setExtraMeat(false);
                    }
                }

            } while (addMoreMeat); // Continue looping if user wants more meat
        }

// Add selected meats to the sandwich if meat is selected
        if (meatSelected) {
            for (String meat : selectedMeats) {
                if (sandwichInstance instanceof BLT) {
                    ((BLT) sandwichInstance).addPremiumTopping(meat);
                } else if (sandwichInstance instanceof Philly) {
                    ((Philly) sandwichInstance).addPremiumTopping(meat);
                }
            }
        }


        // Calculate total cost of extra meat
        int extraMeatCount = selectedMeats.size() - 1; // Exclude the first meat, which is included in the base price
        double extraMeatCost = 0.0;
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

        if(selectedMeats.size() > 1){
            sandwichInstance.setExtraMeat(true);
        }
// Update the total cost of the sandwich
        sandwichInstance.setExtraMeatPrice(extraMeatCost);


    }

    private void setSignatureCheeseToppingsAndBooleanValue(ToppingsManipulable sandwich) {
        Sandwich sandwichInstance = null;

        if (sandwich instanceof BLT) {
            sandwichInstance = (BLT) sandwich;
        } else if (sandwich instanceof Philly) {
            sandwichInstance = (Philly) sandwich;
        }

        List<String> selectedCheeses = new ArrayList<>();
        boolean addMoreCheese = false; // Initialize addMoreMeat
        boolean cheeseSelected = false; // Track if meat is selected

        System.out.print("Would you like to remove any of the current cheese topping? (Y/N): ");
        String userRemoveMeatToppingChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like to remove any of the current cheese topping? (Y/N): ");
        if(userRemoveMeatToppingChoice.equalsIgnoreCase("Y")){
            if (sandwichInstance instanceof BLT) {
                ((BLT) sandwichInstance).removePremiumTopping("Cheddar");
                ((BLT) sandwichInstance).setHasCheese(false);
                ((BLT) sandwichInstance).setCheesePrice(0.00);
                System.out.println("\n ~~ Cheddar Cheese Removed ~~");
            } else if (sandwichInstance instanceof Philly) {
                ((Philly) sandwichInstance).removePremiumTopping("American");
                ((Philly) sandwichInstance).setHasCheese(false);
                ((Philly) sandwichInstance).setCheesePrice(0.00);
                System.out.println("\n ~~ American Cheese Removed ~~");
            }
        }


        System.out.print("\nWould you like Cheese in your sandwich🧀? (Y/N): ");
        String meatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like Cheese in your sandwich🧀? (Y/N): ");

        if (meatChoice.equalsIgnoreCase("Y")) {
            if (sandwichInstance instanceof BLT) {
                ((BLT) sandwichInstance).setHasCheese(true);
                ((BLT) sandwichInstance).setCheesePrice(((BLT) sandwichInstance).getSize().equals("4") ? 1.00 : ((BLT) sandwichInstance).getSize().equals("8") ? 2.00 : 3.00);
                cheeseSelected = true;
            } else if (sandwichInstance instanceof Philly) {
                ((Philly) sandwichInstance).setHasCheese(true);
                ((Philly) sandwichInstance).setCheesePrice(((Philly) sandwichInstance).getSize().equals("4") ? 1.00 : ((Philly) sandwichInstance).getSize().equals("8") ? 2.00 : 3.00);
            }

            // Loop for selecting meat
            do {
                String selectedCheese = UtilityMethods.validateCheeseChoice(scanner, cheeseToppings);
                selectedCheeses.add(selectedCheese);

                System.out.print("\nWould you like more Cheese on your sandwich🧀? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like more Cheese on your sandwich🧀? (Y/N): ");
                addMoreCheese = repeatChoice.equalsIgnoreCase("Y");

                // Set extra meat flag based on user choice
                if (addMoreCheese) {
                    if (sandwichInstance instanceof BLT) {
                        ((BLT) sandwichInstance).setExtraCheese(true);
                    } else if (sandwichInstance instanceof Philly) {
                        ((Philly) sandwichInstance).setExtraCheese(true);
                    }
                } else {
                    if (sandwichInstance instanceof BLT) {
                        ((BLT) sandwichInstance).setExtraCheese(false);
                    } else if (sandwichInstance instanceof Philly) {
                        ((Philly) sandwichInstance).setExtraCheese(false);
                    }
                }

            } while (addMoreCheese); // Continue looping if user wants more meat
        }

// Add selected meats to the sandwich if meat is selected
        if (cheeseSelected) {
            for (String cheese : selectedCheeses) {
                if (sandwichInstance instanceof BLT) {
                    ((BLT) sandwichInstance).addPremiumTopping(cheese);
                } else if (sandwichInstance instanceof Philly) {
                    ((Philly) sandwichInstance).addPremiumTopping(cheese);
                }
            }
        }


        // Calculate total cost of extra meat
        int extraCheeseCount = selectedCheeses.size() - 1; // Exclude the first meat, which is included in the base price
        double extraCheeseCost = 0.0;
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

        if(selectedCheeses.size() > 1){
            sandwichInstance.setExtraCheese(true);
        }

        // Update the total cost of the sandwich
        sandwichInstance.setExtraCheesePrice(extraCheeseCost);
    }

    private void setMeatToppingsAndBooleanValue(Sandwich sandwich) {
        List<String> selectedMeats = new ArrayList<>();
        boolean addMoreMeat = false; // Initialize addMoreMeat
        boolean meatSelected = false; // Track if meat is selected

        System.out.print("\nWould you like meat in your sandwich🍖? (Y/N): ");
        String meatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like meat in your sandwich🍖? (Y/N): ");

        if (meatChoice.equalsIgnoreCase("Y")) {
            sandwich.setHasMeat(true);
            sandwich.setMeatPrice(sandwich.getSize().equals("4") ? 1.00 : sandwich.getSize().equals("8") ? 2.00 : 3.00);
            meatSelected = true;

            // Loop for selecting meat
            do {
                String selectedMeat = UtilityMethods.validateMeatChoice(scanner, meatToppings);
                selectedMeats.add(selectedMeat);

                System.out.print("\nWould you like more meat on your sandwich🥩? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "Would you like more meat on your sandwich🥩? (Y/N): ");
                addMoreMeat = repeatChoice.equalsIgnoreCase("Y");
                if (addMoreMeat == true){
                    sandwich.setExtraMeat(true);
                }else{
                    sandwich.setExtraMeat(false);
                }

            } while (addMoreMeat); // Continue looping if user wants more meat
        }
        // Add selected meats to the sandwich if meat is selected
        if (meatSelected) {
            for (String meat : selectedMeats) {
                sandwich.addPremiumTopping(meat);
            }

            // Calculate total cost of extra meat
            int extraMeatCount = selectedMeats.size() - 1; // Exclude the first meat, which is included in the base price
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

            if(selectedMeats.size() > 1){
                sandwich.setExtraMeat(true);
            }
            // Update the total cost of the sandwich
            sandwich.setExtraMeatPrice(extraMeatCost);
        }

    }

    private void setCheeseToppingsAndBooleanValue(Sandwich sandwich) {
        List<String> selectedCheeses = new ArrayList<>();
        boolean addMoreCheese = false; // Initialize addMoreCheese
        boolean cheeseSelected = false; // Track if cheese is selected

        System.out.print("\nWould you like cheese in your sandwich🧀? (Y/N): ");
        String cheeseChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like cheese in your sandwich🧀? (Y/N): ");

        if (cheeseChoice.equalsIgnoreCase("Y")) {
            sandwich.setHasCheese(true);
            sandwich.setCheesePrice(sandwich.getSize().equals("4") ? 0.75 : sandwich.getSize().equals("8") ? 1.50 : 2.25);
            cheeseSelected = true;

            // Loop for selecting meat
            do {
                String selectedMeat = UtilityMethods.validateCheeseChoice(scanner, cheeseToppings);
                selectedCheeses.add(selectedMeat);

                System.out.print("\nWould you like more cheese on your sandwich🧀? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like more cheese on your sandwich🧀? (Y/N): ");
                addMoreCheese = repeatChoice.equalsIgnoreCase("Y");


            } while (addMoreCheese); // Continue looping if user wants more meat
        }
        // Add selected meats to the sandwich if meat is selected
        if (cheeseSelected) {
            for (String cheese : selectedCheeses) {
                sandwich.addPremiumTopping(cheese);
            }

            // Calculate total cost of extra meat
            int extraCheeseCount = selectedCheeses.size() - 1; // Exclude the first meat, which is included in the base price
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

            if(selectedCheeses.size() > 1){
                sandwich.setExtraCheese(true);
            }

            // Update the total cost of the sandwich
            sandwich.setExtraCheesePrice(extraCheeseCost);
        }

    }

    private void setRegularToppings(Sandwich sandwich){
        List<String> selectedRegularToppings = new ArrayList<>();
        boolean addMoreToppings = false;
        boolean toppingsSelected = false;

        System.out.print("\nWould you like veggie toppings in your sandwich🥗? (Y/N): ");
        String toppingsChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like veggie toppings in your sandwich🥗? (Y/N): ");

        if (toppingsChoice.equalsIgnoreCase("Y")) {
            toppingsSelected = true;

            // Loop for selecting meat
            do {
                String selectedToppings = UtilityMethods.validateToppingsChoice(scanner, regularToppings);
                selectedRegularToppings.add(selectedToppings);

                System.out.print("\nWould you like additional veggie toppings🥒? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like additional veggie toppings🧅? (Y/N): ");
                addMoreToppings = repeatChoice.equalsIgnoreCase("Y");


            } while (addMoreToppings); // Continue looping if user wants more toppings
        }

        // Add selected meats to the sandwich if meat is selected
        if (toppingsSelected) {
            for (String topping : selectedRegularToppings) {
                sandwich.addRegularTopping(topping);
            }
        }
    }

    private void setSaucesToppings(Sandwich sandwich){
        List<String> selectedSauceToppings = new ArrayList<>();
        boolean addMoreSauces = false;
        boolean saucesSelected = false;

        System.out.print("\nWould you like sauce added to your sandwich🧂? (Y/N): ");
        String sauceChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like sauce added to your sandwich🧂? (Y/N): ");

        if (sauceChoice.equalsIgnoreCase("Y")) {
            saucesSelected = true;

            // Loop for selecting meat
            do {
                String selectedSauces = UtilityMethods.validateToppingsChoice(scanner, sauceOptions);
                selectedSauceToppings.add(selectedSauces);

                System.out.print("\nWould you like additional sauces added🧂? (Y/N): ");
                String repeatChoice = UtilityMethods.takeYesOrNoInput(scanner, scanner.nextLine().trim(), "\nWould you like additional sauces added🧂? (Y/N): ");
                addMoreSauces = repeatChoice.equalsIgnoreCase("Y");


            } while (addMoreSauces); // Continue looping if user wants more toppings
        }

        // Add selected meats to the sandwich if meat is selected
        if (saucesSelected) {
            for (String sauce : selectedSauceToppings) {
                sandwich.addRegularTopping(sauce);
            }
        }
    }


    private List<String> loadMeatToppings() {
        List<String> meatToppings = new ArrayList<>();
        meatToppings.add("Roast Beef");
        meatToppings.add("Chicken");
        meatToppings.add("Salami");
        meatToppings.add("Steak");
        meatToppings.add("Bacon");
        meatToppings.add("Ham");
        return meatToppings;
    }


    private List<String> loadCheeseToppings() {
        List<String> cheeseToppings = new ArrayList<>();
        cheeseToppings.add("Provolone");
        cheeseToppings.add("American");
        cheeseToppings.add("Cheddar");
        cheeseToppings.add("Swiss");
        return cheeseToppings;
    }


    private List<String> loadRegularToppings() {
        List<String> regularToppings = new ArrayList<>();
        regularToppings.add("Jalepenos");
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

    private List<String> loadSauceToppings() {
        List<String> sauceToppings = new ArrayList<>();
        sauceToppings.add("Thousand Island");
        sauceToppings.add("Vinaigrette");
        sauceToppings.add("Mustard");
        sauceToppings.add("Ketchup");
        sauceToppings.add("Ranch");
        sauceToppings.add("Mayo");
        return sauceToppings;
    }

}

