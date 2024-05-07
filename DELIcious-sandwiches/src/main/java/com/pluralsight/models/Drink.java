/**
 * Represents a drink order, extending the functionality of the Order class.
 * It provides details about the drink size, type, price, and whether a drink is included.
 */
package com.pluralsight.models;

public class Drink extends Order {
    private boolean hasDrink; // Indicates whether a drink is included in the order

    /**
     * Constructs a Drink object with the specified size, type, drink inclusion status, and size price.
     * @param size The size of the drink.
     * @param type The type or variant of the drink.
     * @param hasDrink Indicates whether a drink is included in the order.
     * @param sizePrice The price of the drink based on its size.
     */
    public Drink(String size, String type, boolean hasDrink, double sizePrice) {
        super(size, type);
        this.hasDrink = hasDrink;
        this.price = sizePrice; // Set the price based on the size
    }

    /**
     * Checks whether a drink is included in the order.
     * @return true if a drink is included; otherwise, false.
     */
    public boolean isHasDrink() {
        return hasDrink;
    }

    /**
     * Sets whether a drink is included in the order.
     * @param hasDrink true if a drink is included; otherwise, false.
     */
    public void setHasDrink(boolean hasDrink) {
        this.hasDrink = hasDrink;
    }

    /**
     * Retrieves the price of the drink.
     * @return The price of the drink.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Overrides the toString method to provide a string representation of the drink order.
     * @return A string representation of the drink order.
     */
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

    /**
     * Capitalizes the first letter of a string.
     * @param str The string to capitalize.
     * @return The string with the first letter capitalized.
     */
    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
