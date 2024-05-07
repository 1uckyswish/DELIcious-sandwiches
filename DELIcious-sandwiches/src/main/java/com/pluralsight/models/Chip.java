/**
 * Represents a chip order, extending the functionality of the Order class.
 * It provides details about the chip type, size, price, and whether chips are included.
 */
package com.pluralsight.models;

public class Chip extends Order {
    private boolean hasChips; // Indicates whether chips are included in the order

    /**
     * Constructs a Chip object with the specified type and chip inclusion status.
     * @param type The type or variant of the chips.
     * @param hasChips Indicates whether chips are included in the order.
     */
    public Chip(String type, boolean hasChips) {
        super("Snack Size", type); // Set the size to "Snack Size" for chips
        this.hasChips = hasChips;
        this.price = 1.50; // Set the default price for chips
    }

    /**
     * Checks whether chips are included in the order.
     * @return true if chips are included; otherwise, false.
     */
    public boolean isHasChips() {
        return hasChips;
    }

    /**
     * Sets whether chips are included in the order.
     * @param hasChips true if chips are included; otherwise, false.
     */
    public void setHasChips(boolean hasChips) {
        this.hasChips = hasChips;
    }

    /**
     * Retrieves the price of the chips.
     * @return The price of the chips.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Overrides the toString method to provide a string representation of the chip order.
     * @return A string representation of the chip order.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|+--------------------------------------+\n");
        sb.append("|Chip Choice: ").append(capitalizeFirstLetter(type)).append("\n");
        sb.append("|Chip Size: ").append(size).append("\n");
        sb.append("|Chip Price: $").append(String.format("%.2f", price)).append("\n");
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
