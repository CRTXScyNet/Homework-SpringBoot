package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorInterface calculator;

    CalculatorController(CalculatorInterface calculator){
        this.calculator = calculator;
    }
    @GetMapping
    public String hello(){
        return calculator.hello();
    }
    @GetMapping(path = "/calculator")
    public String calculate(){
        return calculator.welcome();
    }
    @GetMapping(path = "/calculator/plus")
    public String plus(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        return calculator.plus(n1, n2);
    }
    @GetMapping(path = "/calculator/minus")
    public String minus(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        return calculator.minus(n1, n2);
    }
    @GetMapping(path = "/calculator/multiply")
    public String multiply(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        return calculator.multiply(n1, n2);
    }
    @GetMapping(path = "/calculator/divide")
    public String divide(@RequestParam("num1") String n1, @RequestParam("num2") String n2) {
        return calculator.divide(n1, n2);
    }
}
