package com.pluralsight.models;

public class Chips extends Order{
private boolean hasChips;

    public Chips(String size, String type, boolean hasChips) {
        super(size, type);
        this.hasChips = hasChips;
    }


}
