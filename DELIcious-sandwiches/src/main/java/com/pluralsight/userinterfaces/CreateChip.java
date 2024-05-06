package com.pluralsight.userinterfaces;

import com.pluralsight.models.Chip;
import com.pluralsight.models.Drink;
import com.pluralsight.utilitymethods.UtilityMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateChip {
    private Scanner scanner;
    private List<String> chipChoices = chipInventory();

    public CreateChip(Scanner scanner) {
        this.scanner = scanner;
    }

    public Chip createChips() {
        Chip chip;
        String chipType;

        System.out.println("\n======================================");
        System.out.println("|          Ordering Chips            |");
        System.out.println("======================================\n");
        chipType = UtilityMethods.validateChipChoice(scanner, chipChoices);
        chip = new Chip(chipType, true);

        System.out.println("\n  🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔");
        System.out.println("       🥔  Chips Added  🥔");
        System.out.println("  🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔🥔");

        return chip;
    }

    private List<String> chipInventory() {
        List<String> chipChoices = new ArrayList<>();
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