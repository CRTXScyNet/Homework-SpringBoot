package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CalculatorImpl implements CalculatorInterface {
    @Override
    public String hello() {
        return "Привет, путник!";
    }

    @Override
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    public String plus(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        String check = checkNumbers(n1, n2);
        if (check == null) {
            return n1 + " + " + n2 + " = " + String.valueOf(Integer.parseInt(n1) + Integer.parseInt(n2));
        }else {
            return check;
        }
    }

    public String minus(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        String check = checkNumbers(n1, n2);
        if (check == null) {
            return n1 + " - " + n2 + " = " + String.valueOf(Integer.parseInt(n1) - Integer.parseInt(n2));
        }else {
            return check;
        }
    }

    public String multiply(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        String check = checkNumbers(n1, n2);
        if (check == null) {
            return n1 + " * " + n2 + " = " + String.valueOf(Integer.parseInt(n1) * Integer.parseInt(n2));
        }else {
            return check;
        }
    }

    public String divide(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        String check = checkNumbers(n1, n2);
        if (check == null) {
            double num1 = Integer.parseInt(n1);
            double num2 = Integer.parseInt(n2);
            if(num2 == 0){
                return "Ошибка! На ноль делить нельзя!";
            }
            double result = num1 / num2;
            if (result % 1 == 0){
                return n1 + " / " + n2 + " = " + String.valueOf((int) result);
            }
            return n1 + " / " + n2 + " = " + String.valueOf(result);
        }else {
            return check;
        }
    }

    @Override
    public String checkNumbers(String n1, String n2) {
        if (n1 == null || n2 == null || n1.isBlank() || n2.isBlank()) {
            return "Ошибка! Некоторые параметры отсутствуют!";
        }
        try{
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
        }catch (Exception e){
            return "Ошибка! Некоторые параметры не цифры!";
        }
        return null;
    }
}
