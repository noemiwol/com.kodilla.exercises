package com.kodilla.simpleCalculator.domain;

import org.springframework.stereotype.Service;

@Service
public class Method {
    private double firstNumber;
    private double secondNumber;
    private double result;

    public Method(double firstNumber, double secondNumber, double result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
    }
    public double addition(){

        return result = firstNumber + secondNumber;

    }
    public double subtraction(){

        return result = firstNumber - secondNumber;
    }
    public double multiplication(){

        return result = firstNumber * secondNumber;
    }
    public double division(){

        return result = firstNumber / secondNumber;
    }
}
