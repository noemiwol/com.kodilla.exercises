package com.kodilla.simpleCalculator.domain;

public class CalculatorDto {
    private double firstNumber;
    private double secondNumber;


    public CalculatorDto(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public double addition(){

        return firstNumber + secondNumber;
    }
    public double subtraction(){

        return firstNumber - secondNumber;
    }
    public double multiplication(){

        return firstNumber * secondNumber;
    }
    public double division(){

        return firstNumber / secondNumber;
    }
}
