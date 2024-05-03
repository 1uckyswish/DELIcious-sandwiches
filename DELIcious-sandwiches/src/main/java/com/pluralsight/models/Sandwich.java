package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Order{
    private boolean toasted;
    private double sizePrice;
    private double meatPrice;
    private double cheesePrice;
    private boolean extraMeat;
    private double extraMeatPrice;
    private boolean extraCheese;
    private double extraCheesePrice;
    private boolean hasMeat;
    private boolean hasCheese;
    private List<String> regularToppings;
    private List<String> premiumToppings;

    public Sandwich(String size, String type, boolean toasted) {
        super(size, type);
        this.toasted = toasted;
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
    }

    //For toasted
    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    //For price
    public double getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(double sizePrice) {
        this.sizePrice = sizePrice;
    }

    //For meats
    public double getMeatPrice() {
        return meatPrice;
    }

    public void setMeatPrice(double meatPrice) {
        this.meatPrice = meatPrice;
    }

    //For cheese
    public double getCheesePrice() {
        return cheesePrice;
    }

    public void setCheesePrice(double cheesePrice) {
        this.cheesePrice = cheesePrice;
    }

    //Check for extra meat
    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    //Return and set Extra meat
    public double getExtraMeatPrice() {
        return extraMeatPrice;
    }

    public void setExtraMeatPrice(double extraMeatPrice) {
        this.extraMeatPrice = extraMeatPrice;
    }

    //Check for cheese
    public boolean isExtraCheese() {
        return extraCheese;
    }

    //Return and set Extra cheese
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public double getExtraCheesePrice() {
        return extraCheesePrice;
    }

    public void setExtraCheesePrice(double extraCheesePrice) {
        this.extraCheesePrice = extraCheesePrice;
    }

    //Check for extra meat
    public boolean isHasMeat() {
        return hasMeat;
    }

    //update if meat wanted
    public void setHasMeat(boolean hasMeat) {
        this.hasMeat = hasMeat;
    }

    //check if cheese is wanted
    public boolean isHasCheese() {
        return hasCheese;
    }
    //Update cheese
    public void setHasCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
    }

    //Get all regular toppings
    public List<String> getRegularToppings() {
        return regularToppings;
    }

    //Set the toppings
    public void setRegularToppings(List<String> regularToppings) {
        this.regularToppings = regularToppings;
    }

    //Return all premium toppings
    public List<String> getPremiumToppings() {
        return premiumToppings;
    }
    //Set the premium toppings
    public void setPremiumToppings(List<String> premiumToppings) {
        this.premiumToppings = premiumToppings;
    }

    // Method to add  topping
    public void addRegularTopping(String topping) {
        regularToppings.add(topping);
    }

    // Method to add premium topping
    public void addPremiumTopping(String topping) {
        premiumToppings.add(topping);
    }

    public double calculateTotalPrice() {
        double totalPrice = sizePrice + meatPrice + cheesePrice;
        if (extraMeat) {
            totalPrice += extraMeatPrice;
        }
        if (extraCheese) {
            totalPrice += extraCheesePrice;
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|+--------------------------------------+\n");
        sb.append("|        Sandwich Order Summary         |\n");
        sb.append("|+--------------------------------------+\n");
        sb.append("|Bread Type: ").append(type).append("\n");
        sb.append("|Bread Size: ").append(size).append(" inch\n");
        sb.append("|Base Price: $").append(String.format("%.2f", sizePrice)).append("\n");
        sb.append("|Toasted: ").append(toasted ? "Yes" : "No").append("\n");

        if (!regularToppings.isEmpty()) {
            sb.append("|Regular Toppings:\n");
            for (String topping : regularToppings) {
                if (!topping.equals("4oz Au Jus sauce")) {
                    sb.append("|- ").append(capitalizeFirstLetter(topping)).append("\n");
                }
            }
        }

        if (!premiumToppings.isEmpty()) {
            sb.append("|Premium Toppings:\n");
            for (String topping : premiumToppings) {
                sb.append("|- ").append(capitalizeFirstLetter(topping)).append("\n");
            }
        }

        sb.append("|Toppings cost:\n");
        if (hasMeat) {
            sb.append("|- Meat price: $").append(String.format("%.2f", meatPrice)).append("\n");
            if (extraMeat) {
                sb.append("|  - Extra Meat Cost: $").append(String.format("%.2f", extraMeatPrice)).append("\n");
            }
        }
        if (hasCheese) {
            sb.append("|- Cheese price: $").append(String.format("%.2f", cheesePrice)).append("\n");
            if (extraCheese) {
                sb.append("|  - Extra Cheese Cost: $").append(String.format("%.2f", extraCheesePrice)).append("\n");
            }
        }

        if (regularToppings.contains("4oz Au Jus sauce")) {
            sb.append("|Sides: 4oz Au Jus sauce\n");
        }

        sb.append("|Total Price: $").append(String.format("%.2f", price)).append("\n");
        sb.append("|+--------------------------------------+\n");

        return sb.toString();
    }

    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }


}
