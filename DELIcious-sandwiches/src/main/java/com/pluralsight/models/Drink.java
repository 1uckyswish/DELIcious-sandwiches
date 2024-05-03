package com.pluralsight.models;

public class Drink extends Order{
    private boolean hasDrink;
    private double sizePrice;

    public Drink(String size, String type, boolean hasDrink, double sizePrice) {
        super(size, type);
        this.hasDrink = hasDrink;
        this.sizePrice = sizePrice;
    }

    public boolean isHasDrink() {
        return hasDrink;
    }

    public void setHasDrink(boolean hasDrink) {
        this.hasDrink = hasDrink;
    }

    public double getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(double sizePrice) {
        this.sizePrice = sizePrice;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "hasDrink=" + hasDrink +
                ", sizePrice=" + sizePrice +
                ", size='" + size + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
