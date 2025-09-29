package com.spe.calculator;

/**
 * Custom exception thrown when a factorial calculation exceeds the capacity of a long.
 */
class FactorialOverflowException extends RuntimeException {
    public FactorialOverflowException(String message) {
        super(message);
    }
}

/**
 * ScientificCalculator class provides basic scientific operations.
 * This class will be the core component for the Mini Project.
 */
public class ScientificCalculator {

    /**
     * Calculates the square root of a number.
     * @param x The number to calculate the square root of. Must be non-negative.
     * @return The square root of x.
     * @throws IllegalArgumentException if x is negative.
     */
    public double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Square root is not defined for negative numbers.");
        }
        return Math.sqrt(x);
    }

    /**
     * Calculates the factorial of a non-negative integer.
     * This implementation uses a simple iterative approach.
     * @param n The number to calculate the factorial of. Must be non-negative.
     * @return The factorial of n as a long.
     * @throws IllegalArgumentException if n is negative.
     * @throws FactorialOverflowException if n is too large (> 20) for a long to hold.
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        // 20! is the largest factorial that fits in a standard long.
        if (n > 20) {
            throw new FactorialOverflowException("Input (" + n + ") is too large. Factorial calculation will overflow a standard 'long'. Max supported is 20.");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Calculates the natural logarithm (base e) of a number.
     * @param x The number to calculate the natural log of. Must be positive.
     * @return The natural logarithm of x.
     * @throws IllegalArgumentException if x is not positive (x <= 0).
     */
    public double naturalLog(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Natural logarithm is only defined for positive numbers (x > 0).");
        }
        return Math.log(x);
    }

    /**
     * Calculates the result of a number raised to a power (x^b).
     * @param x The base number.
     * @param b The exponent.
     * @return x raised to the power of b.
     */
    public double power(double x, double b) {
        return Math.pow(x, b);
    }
}
