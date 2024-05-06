package com.pluralsight.models;

public class Philly extends Sandwich implements ToppingsManipulable {
    public Philly(String size, String type, boolean toasted) {
        super(size, type, toasted);
    }

    @Override
    public void removeRegularTopping(String topping) {

    }

    @Override
    public void removePremiumTopping(String topping) {

    }
}
