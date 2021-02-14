package com.kodilla.simpleCalculator.event;

import org.springframework.context.ApplicationEvent;

public class CalculationsMade extends ApplicationEvent {
    private double firstNumber;
    private double secondNumber;

    public CalculationsMade(Object source, double firstNumber, double secondNumber) {
        super(source);
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;


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
