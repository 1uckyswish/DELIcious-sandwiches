package com.pluralsight.models;

public class Chip extends Order {
    private boolean hasChips;

    public Chip(String type, boolean hasChips) {
        super("Snack Size", type);
        this.hasChips = hasChips;
        this.price = 1.50;
    }

    public boolean isHasChips() {
        return hasChips;
    }

    public void setHasChips(boolean hasChips) {
        this.hasChips = hasChips;
    }

    @Override
    public double getPrice() {
        return price;
    }

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

    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}