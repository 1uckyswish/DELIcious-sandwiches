package com.pluralsight.userInterfaces;
import com.pluralsight.utilityMethods.UtilityMethods;
import java.util.Scanner;

public class CreateSandwich {
    private Scanner scanner;

    public CreateSandwich(Scanner scanner) {
        this.scanner = scanner;
    }

    public String createSandwich() {
        System.out.println("Creating a new sandwich:");
        // Sandwich size
        System.out.println("What size sandwich would you like?");
        System.out.println("Sandwich size:");
        System.out.println("1) 4-inch");
        System.out.println("2) 8-inch");
        System.out.println("3) 12-inch");
        System.out.print("Enter your choice (1, 2, 3): ");
        String sizeChoice = UtilityMethods.takeBreadInput(scanner, scanner.nextLine(), "Enter your choice (1, 2, 3): ");
        // No need to call scanner.nextLine() again as it's already consumed by UtilityMethods.takeBreadInput()
        System.out.println(sizeChoice);
        return "hello";
    }
}

