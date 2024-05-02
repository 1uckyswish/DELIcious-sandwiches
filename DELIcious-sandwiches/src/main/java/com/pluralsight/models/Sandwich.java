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
        return "Sandwich{" +
                "toasted=" + toasted +
                ", sizePrice=" + sizePrice +
                ", meatPrice=" + meatPrice +
                ", cheesePrice=" + cheesePrice +
                ", extraMeat=" + extraMeat +
                ", extraMeatPrice=" + extraMeatPrice +
                ", extraCheese=" + extraCheese +
                ", extraCheesePrice=" + extraCheesePrice +
                ", hasMeat=" + hasMeat +
                ", hasCheese=" + hasCheese +
                ", regularToppings=" + regularToppings +
                ", premiumToppings=" + premiumToppings +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
