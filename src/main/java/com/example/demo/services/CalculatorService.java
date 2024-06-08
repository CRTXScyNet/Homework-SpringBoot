package com.example.demo.services;

public interface CalculatorService {

    String welcome();

    String plus(String n1, String n2);

    String minus(String n1, String n2);

    String multiply(String n1, String n2);

    String divide(String n1, String n2);

    void checkNumbers(String n1, String n2);
}
