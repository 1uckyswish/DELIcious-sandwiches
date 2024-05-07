/**
 * Interface for manipulating toppings of a sandwich.
 * This interface defines methods for removing regular and premium toppings.
 */
package com.pluralsight.models;

public interface ToppingsManipulate {
    /**
     * Removes a regular topping from the sandwich.
     *
     * @param topping The name of the regular topping to be removed.
     */
    void removeRegularTopping(String topping);

    /**
     * Removes a premium topping from the sandwich.
     *
     * @param topping The name of the premium topping to be removed.
     */
    void removePremiumTopping(String topping);
}
