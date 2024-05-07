package com.pluralsight.models;

public class Cookie extends Order {
    private boolean hasCookie; // Indicates whether a cookie is included in the cookie

    /**
     * Constructs a Cookie object with the specified type, size, price.
     */
    public Cookie() {
        // By default, set it to Chocolate Chip
        super("Medium", "Chocolate Chip"); // Set the size and type for cookies
        this.hasCookie = true; // Chocolate chips are included by default
        this.price = 1.25; // Set the default price for cookies
    }

    /**
     * Checks whether a cookie is included in the cookie.
     *
     * @return true if a cookie is included; otherwise, false.
     */
    public boolean hasCookie() {
        return hasCookie;
    }

    /**
     * Sets whether a cookie is included in the cookie.
     *
     * @param hasCookie true if a cookie is included; otherwise, false.
     */
    public void setChocolateChips(boolean hasCookie) {
        this.hasCookie = hasCookie;
    }

    /**
     * Retrieves the price of the cookie.
     *
     * @return The price of the cookie.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Overrides the toString method to provide a string representation of the
     * cookie order.
     *
     * @return A string representation of the cookie order.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|+--------------------------------------+\n");
        sb.append("|Cookie Type: ").append(capitalizeFirstLetter(type)).append("\n");
        sb.append("|Cookie Size: ").append(size).append("\n");
        sb.append("|Cookie Price: $").append(String.format("%.2f", price)).append("\n");
        sb.append("|+--------------------------------------+\n");
        return sb.toString();
    }

    /**
     * Capitalizes the first letter of a string.
     *
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
