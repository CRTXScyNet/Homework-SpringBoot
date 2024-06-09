package com.example.demo.controllers;

import com.example.demo.exceptions.DivideByZeroException;
import com.example.demo.services.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
    private final CalculatorService calculator;

    CalculatorController(CalculatorService calculator) {
        this.calculator = calculator;
    }

    @GetMapping
    public String calculate() {
        return calculator.welcome();
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        return calculator.plus(n1, n2);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        return calculator.minus(n1, n2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        return calculator.multiply(n1, n2);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        try {
            return calculator.divide(n1, n2);
        } catch (DivideByZeroException e) {
            return e.getMessage();
        }
    }
}
