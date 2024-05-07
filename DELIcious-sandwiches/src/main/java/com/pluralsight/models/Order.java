/**
 * Represents an order, providing the size, type, and price of the ordered item.
 * This class serves as a base class for specific types of orders, providing common functionality and properties.
 */
package com.pluralsight.models;

public class Order {
    protected String size; // Size of the ordered item
    protected String type; // Type or variant of the ordered item
    protected double price; // Price of the ordered item

    /**
     * Constructs an Order object with the specified size and type.
     * @param size The size of the ordered item.
     * @param type The type or variant of the ordered item.
     */
    public Order(String size, String type) {
        this.size = size;
        this.type = type;
    }

    /**
     * Retrieves the size of the ordered item.
     * @return The size of the ordered item.
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size of the ordered item.
     * @param size The size of the ordered item.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Retrieves the type or variant of the ordered item.
     * @return The type or variant of the ordered item.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type or variant of the ordered item.
     * @param type The type or variant of the ordered item.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retrieves the price of the ordered item.
     * @return The price of the ordered item.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the ordered item.
     * @param price The price of the ordered item.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
