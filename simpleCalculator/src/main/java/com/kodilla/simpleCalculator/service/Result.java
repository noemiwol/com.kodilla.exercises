package com.kodilla.simpleCalculator.service;

import com.kodilla.simpleCalculator.event.CalculationsMade;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Result implements ApplicationListener<CalculationsMade> {
    @Override
    public void onApplicationEvent(CalculationsMade calculationsMade) {
        System.out.println("Result of addition: " + calculationsMade.addition());
        System.out.println("Result of subtraction: " + calculationsMade.subtraction());
        System.out.println("Result of multiplication: " + calculationsMade.multiplication());
        System.out.println("Result of division: " + calculationsMade.division());
    }

}
