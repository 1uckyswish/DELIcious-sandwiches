package com.pluralsight.models;

public class Drink extends Order{
    private boolean hasDrink;

    public Drink(String size, String type, boolean hasDrink) {
        super(size, type);
        this.hasDrink = hasDrink;
    }
}
