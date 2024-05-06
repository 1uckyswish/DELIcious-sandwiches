package com.pluralsight.models;

public class Drink extends Order {
    private boolean hasDrink;

    public Drink(String size, String type, boolean hasDrink, double sizePrice) {
        super(size, type);
        this.hasDrink = hasDrink;
        this.price = sizePrice;
    }

    public boolean isHasDrink() {
        return hasDrink;
    }

    public void setHasDrink(boolean hasDrink) {
        this.hasDrink = hasDrink;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|+--------------------------------------+\n");
        sb.append("|Drink Choice: ").append(capitalizeFirstLetter(type)).append("\n");
        sb.append("|Drink Size: ").append(size).append("\n");
        sb.append("|Drink Price: $").append(String.format("%.2f", price)).append("\n");
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