package com.example.demo.services;

import com.example.demo.exceptions.DivideByZeroException;
import com.example.demo.exceptions.NotNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceImplTest {
    private final CalculatorService out = new CalculatorServiceImpl();

    @Test
    void plus1() {
        String s = out.plus("5", "5");
        assertEquals(s, "5 + 5 = 10");
    }

    @Test
    void plus2() {
        String s = out.plus("4", "4");
        assertEquals(s, "4 + 4 = 8");
    }

    @Test
    void minus1() {
        String s = out.minus("5", "5");
        assertEquals(s, "5 - 5 = 0");
    }

    @Test
    void minus2() {
        String s = out.minus("15", "5");
        assertEquals(s, "15 - 5 = 10");
    }

    @Test
    void multiply1() {
        String s = out.multiply("5", "5");
        assertEquals(s, "5 * 5 = 25");
    }

    @Test
    void multiply2() {
        String s = out.multiply("2", "5");
        assertEquals(s, "2 * 5 = 10");
    }

    @Test
    void divide1() {
        String s = out.divide("5", "5");
        assertEquals(s, "5 / 5 = 1");
    }

    @Test
    void divide2() {
        String s = out.divide("10", "5");
        assertEquals(s, "10 / 5 = 2");
    }

    @Test
    void divideByZero() {
        assertThrows(DivideByZeroException.class, () -> out.divide("5", "0"));
    }

    @Test
    void checkNullNumbers1() {
        assertThrows(IllegalArgumentException.class, () -> out.checkNumbers(null, "1"));
    }

    @Test
    void checkNullNumbers2() {
        assertThrows(IllegalArgumentException.class, () -> out.checkNumbers("1", null));
    }

    @Test
    void checkNullNumbers3() {
        assertThrows(IllegalArgumentException.class, () -> out.checkNumbers(null, null));
    }

    @Test
    void checkBlankNumbers1() {
        assertThrows(IllegalArgumentException.class, () -> out.checkNumbers("1", ""));
    }

    @Test
    void checkBlankNumbers2() {
        assertThrows(IllegalArgumentException.class, () -> out.checkNumbers("", "1"));
    }

    @Test
    void checkBlankNumbers3() {
        assertThrows(IllegalArgumentException.class, () -> out.checkNumbers("", ""));
    }

    @Test
    void checkNotNumbers1() {
        assertThrows(NotNumberException.class, () -> out.checkNumbers("1", "f"));
    }

    @Test
    void checkNotNumbers2() {
        assertThrows(NotNumberException.class, () -> out.checkNumbers("f", "1"));
    }

    @Test
    void checkNotNumbers3() {
        assertThrows(NotNumberException.class, () -> out.checkNumbers("f", "f"));
    }
}