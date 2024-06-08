package com.example.demo.services;

import com.example.demo.exceptions.DivideByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public String plus(String n1, String n2) {
        checkNumbers(n1, n2);
        return n1 + " + " + n2 + " = " + String.valueOf(Integer.parseInt(n1) + Integer.parseInt(n2));
    }

    @Override
    public String minus(String n1, String n2) {
        checkNumbers(n1, n2);
        return n1 + " - " + n2 + " = " + String.valueOf(Integer.parseInt(n1) - Integer.parseInt(n2));
    }

    @Override
    public String multiply(String n1, String n2) {
        checkNumbers(n1, n2);
        return n1 + " * " + n2 + " = " + String.valueOf(Integer.parseInt(n1) * Integer.parseInt(n2));
    }

    @Override
    public String divide(String n1, String n2) {
        checkNumbers(n1, n2);
        double num1 = Integer.parseInt(n1);
        double num2 = Integer.parseInt(n2);
        if (num2 == 0) {
            throw new DivideByZeroException("Ошибка! На ноль делить нельзя!");
        }
        double result = num1 / num2;
        if (result % 1 == 0) {
            return n1 + " / " + n2 + " = " + String.valueOf((int) result);
        }
        return n1 + " / " + n2 + " = " + String.valueOf(result);
    }

    @Override
    public void checkNumbers(String n1, String n2) {
        if (n1 == null || n2 == null || n1.isBlank() || n2.isBlank()) {
            throw new IllegalArgumentException("Ошибка! Некоторые параметры отсутствуют!");
        }
        try {
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка! Некоторые параметры не цифры!");
        }
    }
}
