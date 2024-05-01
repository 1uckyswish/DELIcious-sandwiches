package com.pluralsight.models;

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
        this.regularToppings = regularToppings;
        this.premiumToppings = premiumToppings;
    }

}
