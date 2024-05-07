/**
 * Represents the interface for creating a chip order.
 * This class handles the creation of chip objects based on user input.
 */
package com.pluralsight.userinterfaces;

import com.pluralsight.models.Chip;
import com.pluralsight.utilitymethods.UtilityMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateChip {
    private final Scanner scanner;
    private final List<String> chipChoices = chipInventory();

    /**
     * Constructs a CreateChip object with the provided scanner.
     * @param scanner The scanner object used for user input.
     */
    public CreateChip(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Creates a chip object based on user input.
     * @return The created chip object.
     */
    public Chip createChips() {
        Chip chip;
        String chipType;

        System.out.println("\n======================================");
        System.out.println("|          Ordering Chips            |");
        System.out.println("======================================\n");

        // Prompt user to select chip type
        chipType = UtilityMethods.validateChipChoice(scanner, chipChoices);

        // Create chip object with user choice
        chip = new Chip(chipType, true);

        // Confirmation message
        System.out.println("\n  🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔");
        System.out.println("       🥔  Chips Added  🥔");
        System.out.println("  🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔");

        return chip;
    }

    /**
     * Loads the list of available chip choices.
     * @return A list of available chip choices.
     */
    private List<String> chipInventory() {
        List<String> chipChoices = new ArrayList<>();
        // Populate list with available chip choices
        chipChoices.add("SunChips");
        chipChoices.add("Doritos");
        chipChoices.add("Pringles");
        chipChoices.add("Cheetos");
        chipChoices.add("Ruffles");
        chipChoices.add("Takis");
        chipChoices.add("Lays");

        return chipChoices;
    }
}
