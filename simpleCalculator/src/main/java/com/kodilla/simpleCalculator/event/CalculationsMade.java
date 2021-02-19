package com.kodilla.simpleCalculator.event;

import com.kodilla.simpleCalculator.service.MethodNames;
import org.springframework.context.ApplicationEvent;

public class CalculationsMade extends ApplicationEvent {

    private double firstNumber;
    private double secondNumber;
    private double result;
    private MethodNames methodNames;

    public CalculationsMade(Object source, MethodNames methodNames, double number1, double number2, double result) {
        super(source);
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public double getResult() {
        return result;
    }

    public MethodNames getMethodNames() {
        return methodNames;
    }
}
