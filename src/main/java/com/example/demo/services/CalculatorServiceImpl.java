package com.example.demo.services;

import com.example.demo.exceptions.DivideByZeroException;
import com.example.demo.exceptions.NotNumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    Logger logger = LoggerFactory.getLogger(CalculatorServiceImpl.class.getName());

    @Override
    public String plus(String n1, String n2) {
        try {
            checkNumbers(n1, n2);
        } catch (IllegalArgumentException | NotNumberException e) {
            return e.getMessage();
        }
        return n1 + " + " + n2 + " = " + String.valueOf(Integer.parseInt(n1) + Integer.parseInt(n2));
    }

    @Override
    public String minus(String n1, String n2) {
        try {
            checkNumbers(n1, n2);
        } catch (IllegalArgumentException | NotNumberException e) {
            return e.getMessage();
        }
        return n1 + " - " + n2 + " = " + String.valueOf(Integer.parseInt(n1) - Integer.parseInt(n2));
    }

    @Override
    public String multiply(String n1, String n2) {
        try {
            checkNumbers(n1, n2);
        } catch (IllegalArgumentException | NotNumberException e) {
            return e.getMessage();
        }
        return n1 + " * " + n2 + " = " + String.valueOf(Integer.parseInt(n1) * Integer.parseInt(n2));
    }

    @Override
    public String divide(String n1, String n2) {
        try {
            checkNumbers(n1, n2);
        } catch (IllegalArgumentException | NotNumberException e) {
            return e.getMessage();
        }
        double num1 = Integer.parseInt(n1);
        double num2 = Integer.parseInt(n2);
        if (num2 == 0) {
            logger.info("Ошибка! На ноль делить нельзя!");
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
            logger.info("Ошибка! Некоторые параметры отсутствуют!");
            throw new IllegalArgumentException("Ошибка! Некоторые параметры отсутствуют!");
        }
        try {
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
        } catch (Exception e) {
            logger.info("Ошибка! Некоторые параметры не цифры!");
            throw new NotNumberException("Ошибка! Некоторые параметры не цифры!");
        }
    }


}
