package com.spe.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for ScientificCalculator.
 */
public class ScientificCalculatorTest {

    private ScientificCalculator calculator;
    private static final double DELTA = 1e-9; // Tolerance for floating point comparisons

    // Setup method run before each test
    @BeforeEach
    void setUp() {
        calculator = new ScientificCalculator();
    }

    // --- Factorial Function Tests ---

    // Modification: Using custom exception for large input
    @Test
    @DisplayName("Factorial Test: Very Large Input (Throws FactorialOverflowException)")
    void factorial_veryLargeInput_throwsCustomException() {
        // Input > 20 should throw the custom exception
        int veryLargeInput = 25;
        assertThrows(FactorialOverflowException.class, () -> {
            calculator.factorial(veryLargeInput);
        }, "Factorial of a number > 20 should throw FactorialOverflowException.");
    }

    @Test
    @DisplayName("Factorial Test: Positive Input (> 0)")
    void factorial_positiveInput_returnsCorrectValue() {
        // Test case for x > 0, e.g., 5! = 120
        assertEquals(120, calculator.factorial(5), "Factorial of 5 should be 120.");
    }

    // Test case for zero
    @Test
    @DisplayName("Factorial Test: Input Zero (0)")
    void factorial_inputZero_returnsOne() {
        // Test case for x = 0, where 0! = 1
        assertEquals(1, calculator.factorial(0), "Factorial of 0 should be 1.");
    }

    // Test case for negative
    @Test
    @DisplayName("Factorial Test: Negative Input (< 0)")
    void factorial_negativeInput_throwsException() {
        // Test case for x < 0, which should throw an IllegalArgumentException
        int negativeInput = -5;
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(negativeInput);
        }, "Factorial of a negative number should throw an exception.");
    }

    // --- Square Root Function Tests ---

//    @Test
//    @DisplayName("Square Root Test: Positive Number")
//    void squareRoot_positiveInput_returnsCorrectValue() {
//        assertEquals(5.0, calculator.squareRoot(25.0), DELTA, "Square root of 25 should be 5.0.");
//    }

    // new testcase added
//    @Test
//    @DisplayName("Square Root Test: Positive Number")
//    void squareRoot_anotherPositiveInput_returnsCorrectValue() {
//        assertEquals(6.0, calculator.squareRoot(36.0), DELTA, "Square root of 36 should be 6.0.");
//    }

    @Test
    @DisplayName("Square Root Test: Zero")
    void squareRoot_zero_returnsZero() {
        assertEquals(0.0, calculator.squareRoot(0.0), DELTA, "Square root of 0 should be 0.0.");
    }

    @Test
    @DisplayName("Square Root Test: Negative Number")
    void squareRoot_negativeInput_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.squareRoot(-4.0);
        }, "Square root of a negative number should throw an exception.");
    }

    // --- Natural Logarithm Function Tests ---

    @Test
    @DisplayName("Natural Log Test: Positive Number")
    void naturalLog_positiveInput_returnsCorrectValue() {
        // ln(e) = 1.0
        assertEquals(1.0, calculator.naturalLog(Math.E), DELTA, "Natural log of e should be 1.0.");
    }

    @Test
    @DisplayName("Natural Log Test: Input Zero")
    void naturalLog_inputZero_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.naturalLog(0.0);
        }, "Natural log of 0 should throw an exception.");
    }

    @Test
    @DisplayName("Natural Log Test: Negative Number")
    void naturalLog_negativeInput_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.naturalLog(-5.0);
        }, "Natural log of a negative number should throw an exception.");
    }

    // --- Power Function Tests ---
    @Test
    @DisplayName("Power Test: Positive Base, Positive Exponent")
    void power_positiveBase_positiveExponent_returnsCorrectValue() {
        // 5^4 = 625
        assertEquals(625.0, calculator.power(5.0, 4.0), DELTA, "5^4 should be 625.0.");
    }

    @Test
    @DisplayName("Power Test: Positive Base, Zero Exponent")
    void power_positiveBase_zeroExponent_returnsCorrectValue() {
        // 5^0 = 1
        assertEquals(1.0, calculator.power(5.0, 0.0), DELTA, "5^0 should be 1.0.");
    }

    @Test
    @DisplayName("Power Test: Positive Base, Negative Exponent")
    void power_positiveBase_negativeExponent_returnsCorrectValue() {
        // 5^(-2) = 1/25 = 0.04
        assertEquals(0.04, calculator.power(5.0, -2.0), DELTA, "5^(-2) should be 0.04.");
    }

    // Zero base cases
    @Test
    @DisplayName("Power Test: Zero Base, Positive Exponent")
    void power_zeroBase_positiveExponent_returnsCorrectValue() {
        // 0^5 = 0
        assertEquals(0.0, calculator.power(0.0, 5.0), DELTA, "0^5 should be 0.0.");
    }

    @Test
    @DisplayName("Power Test: Zero Base, Zero Exponent (Indeterminate Form)")
    void power_zeroBase_zeroExponent_returnsOneByConvention() {
        // 0^0 is mathematically indeterminate, but often defined as 1
        assertEquals(1.0, calculator.power(0.0, 0.0), DELTA, "0^0 should return 1.0 by convention.");
    }

    // Negative base cases
    @Test
    @DisplayName("Power Test: Negative Base, Positive Odd Exponent")
    void power_negativeBase_positiveOddExponent_returnsNegativeValue() {
        // (-2)^3 = -8
        assertEquals(-8.0, calculator.power(-2.0, 3.0), DELTA, "(-2)^3 should be -8.0.");
    }

    @Test
    @DisplayName("Power Test: Negative Base, Positive Even Exponent")
    void power_negativeBase_positiveEvenExponent_returnsPositiveValue() {
        // (-2)^4 = 16
        assertEquals(16.0, calculator.power(-2.0, 4.0), DELTA, "(-2)^4 should be 16.0.");
    }

    @Test
    @DisplayName("Power Test: Negative Base, Zero Exponent")
    void power_negativeBase_zeroExponent_returnsOne() {
        // (-2)^0 = 1
        assertEquals(1.0, calculator.power(-2.0, 0.0), DELTA, "(-2)^0 should be 1.0.");
    }
}
