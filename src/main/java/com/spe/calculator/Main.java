package com.spe.calculator; // Package name fixed to match the path: com/spe/calculator

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class for the Scientific Calculator, providing a user menu driven interface.
 */
public class Main {

    private static final ScientificCalculator calculator = new ScientificCalculator();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Scientific Calculator!");
        int choice;

//        do {
            displayMenu();
            try {
                long testResult = calculator.factorial(5); // Calculate 5!
                System.out.println("\nCI/CD Test: Factorial of 5 is: " + testResult);
            } catch (Exception e) {
                System.out.println("CI/CD Test Failed: " + e.getMessage());
            }
//            choice = getIntInput("Enter your choice (1-5): ");
//
//            try {
//                processChoice(choice);
//            } catch (InputMismatchException e) {
//                System.out.println("ERROR: Invalid input type. Please enter a number.");
//                scanner.next(); // Clear the invalid input
//            } catch (IllegalArgumentException | FactorialOverflowException e) {
//                System.out.println("CALCULATION ERROR: " + e.getMessage());
//            } catch (Exception e) {
//                System.out.println("An unexpected error occurred: " + e.getMessage());
//            }

//        } while (choice != 5);

        System.out.println("Thank you for using the Scientific Calculator. Goodbye!");
    }

    private static void displayMenu() {
        System.out.println("\n-------------------------------------------");
        System.out.println("      Scientific Calculator Operations");
        System.out.println("-------------------------------------------");
        System.out.println("1. Square Root (√x)");
        System.out.println("2. Factorial (!x)");
        System.out.println("3. Natural Logarithm (ln(x))");
        System.out.println("4. Power (x^b)");
        System.out.println("5. Exit");
        System.out.println("-------------------------------------------");
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        // We rely on InputMismatchException handling in main loop for non-integer inputs
        return scanner.nextInt();
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        // We rely on InputMismatchException handling in main loop for non-double inputs
        return scanner.nextDouble();
    }

    private static void processChoice(int choice) {
        double x, b, result;
        int n;

        switch (choice) {
            case 1: // Square Root
                x = getDoubleInput("Enter the number (x >= 0): ");
                result = calculator.squareRoot(x);
                System.out.printf("Result: √%.2f = %.4f%n", x, result);
                break;
            case 2: // Factorial
                // Note: Factorial is traditionally defined for non-negative integers.
                n = (int) getDoubleInput("Enter the non-negative integer (x <= 20): ");
                long factorialResult = calculator.factorial(n);
                System.out.printf("Result: !%d = %d%n", n, factorialResult);
                break;
            case 3: // Natural Logarithm
                x = getDoubleInput("Enter the number (x > 0): ");
                result = calculator.naturalLog(x);
                System.out.printf("Result: ln(%.2f) = %.4f%n", x, result);
                break;
            case 4: // Power
                x = getDoubleInput("Enter the base (x): ");
                b = getDoubleInput("Enter the exponent (b): ");
                result = calculator.power(x, b);
                System.out.printf("Result: %.2f ^ %.2f = %.4f%n", x, b, result);
                break;
            case 5:
                // Exit handled in main loop
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
    }
}
