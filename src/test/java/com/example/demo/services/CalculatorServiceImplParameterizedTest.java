package com.example.demo.services;

import com.example.demo.exceptions.DivideByZeroException;
import com.example.demo.exceptions.NotNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceImplParameterizedTest {
    private final CalculatorService out = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource(value = "plusArguments")
    void plus(String num1, String num2, String expectedResult) {
        String s = out.plus(num1, num2);
        assertEquals(s, expectedResult);
    }

    public static Stream<Arguments> plusArguments() {
        return Stream.of(
                Arguments.of("5", "5", "5 + 5 = 10"),
                Arguments.of("4", "4", "4 + 4 = 8"),
                Arguments.of("10", "10", "10 + 10 = 20"),
                Arguments.of("2", "5", "2 + 5 = 7")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "minusArguments")
    void minus(String num1, String num2, String expectedResult) {
        String s = out.minus(num1, num2);
        assertEquals(s, expectedResult);
    }

    public static Stream<Arguments> minusArguments() {
        return Stream.of(
                Arguments.of("5", "5", "5 - 5 = 0"),
                Arguments.of("4", "5", "4 - 5 = -1"),
                Arguments.of("10", "4", "10 - 4 = 6"),
                Arguments.of("2", "5", "2 - 5 = -3")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "multiplyArguments")
    void multiply(String num1, String num2, String expectedResult) {
        String s = out.multiply(num1, num2);
        assertEquals(s, expectedResult);
    }

    public static Stream<Arguments> multiplyArguments() {
        return Stream.of(
                Arguments.of("5", "5", "5 * 5 = 25"),
                Arguments.of("4", "5", "4 * 5 = 20"),
                Arguments.of("10", "4", "10 * 4 = 40"),
                Arguments.of("2", "5", "2 * 5 = 10")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "divideArguments")
    void divide(String num1, String num2, String expectedResult) {
        String s = out.divide(num1, num2);
        assertEquals(s, expectedResult);
    }

    public static Stream<Arguments> divideArguments() {
        return Stream.of(
                Arguments.of("5", "5", "5 / 5 = 1"),
                Arguments.of("4", "5", "4 / 5 = 0.8"),
                Arguments.of("10", "4", "10 / 4 = 2.5"),
                Arguments.of("2", "5", "2 / 5 = 0.4")
        );
    }

    @Test
    void divideByZero() {
        assertThrows(DivideByZeroException.class, () -> out.divide("5", "0"));
    }

    @ParameterizedTest
    @MethodSource(value = "nullNumberArguments")
    void checkNullNumbers1(String num1, String num2) {
        assertThrows(IllegalArgumentException.class, () -> out.checkNumbers(num1, num2));
    }

    public static Stream<Arguments> nullNumberArguments() {
        return Stream.of(
                Arguments.of(null, "1"),
                Arguments.of("1", null),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "blankNumberArguments")
    void checkBlankNumbers1(String num1, String num2) {
        assertThrows(IllegalArgumentException.class, () -> out.checkNumbers(num1, num2));
    }

    public static Stream<Arguments> blankNumberArguments() {
        return Stream.of(
                Arguments.of("", "1"),
                Arguments.of("1", ""),
                Arguments.of("", "")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "notNumbersArguments")
    void checkNotNumbers(String num1, String num2) {
        assertThrows(NotNumberException.class, () -> out.checkNumbers(num1, num2));
    }

    public static Stream<Arguments> notNumbersArguments() {
        return Stream.of(
                Arguments.of("f", "1"),
                Arguments.of("1", "f"),
                Arguments.of("f", "f")
        );
    }
}