package com.kodilla.simpleCalculator.service;

import com.kodilla.simpleCalculator.event.CalculationsMade;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Result implements ApplicationListener<CalculationsMade> {

    @Override
    public void onApplicationEvent(CalculationsMade calculationsMade) {
        System.out.println("I register the operation: " + calculationsMade.getMethodNames());
        System.out.println("The first number entered: " + calculationsMade.getFirstNumber());
        System.out.println("The second number entered: " + calculationsMade.getSecondNumber());
        System.out.println("Operation result: " + calculationsMade.getResult());

    }

}
