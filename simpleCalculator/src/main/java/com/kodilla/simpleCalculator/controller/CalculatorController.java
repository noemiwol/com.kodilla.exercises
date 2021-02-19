package com.kodilla.simpleCalculator.controller;

import com.kodilla.simpleCalculator.event.CalculationsMade;
import com.kodilla.simpleCalculator.service.CalculatorService;
import com.kodilla.simpleCalculator.service.MethodNames;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")

public class CalculatorController  implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    private final CalculatorService calculatorService;
    private final MethodNames methodNames;
    private final CalculationsMade calculationsMade;

    public CalculatorController(CalculatorService calculatorService, MethodNames methodNames, CalculationsMade calculationsMade) {
        this.calculatorService = calculatorService;
        this.methodNames = methodNames;
        this.calculationsMade = calculationsMade;
    }

    @GetMapping(path = "cal/add")
    public double addition(@RequestParam double number1, @RequestParam double number2) {
        double result = calculatorService.addition(number1,number2);
        /*System.out.println("The first number was introduced: " + calculationsMade.getFirstNumber());
        System.out.println("The second number was introduced: " + calculationsMade.getSecondNumber());*/
        publisher.publishEvent(
                new CalculationsMade(
                        this, methodNames, number1, number2, result));
    return result;
    }
    @GetMapping(path = "cal/division")
    public double division(@RequestParam double number1, @RequestParam double number2) {
        double result = calculatorService.division(number1,number2);
        /*System.out.println("The first number was introduced: " + calculationsMade.getFirstNumber());
        System.out.println("The second number was introduced: " + calculationsMade.getSecondNumber());*/
        publisher.publishEvent(
                new CalculationsMade(
                        this,methodNames, number1, number2, result));
        return result;
    }
    @GetMapping(path = "cal/subtraction")
    public double subtraction(@RequestParam double number1, @RequestParam double number2) {
        double result = calculatorService.subtraction(number1,number2);
        /*System.out.println("The first number was introduced: " + calculationsMade.getFirstNumber());
        System.out.println("The second number was introduced: " + calculationsMade.getSecondNumber());*/
        publisher.publishEvent(
                new CalculationsMade(
                        this, methodNames, number1, number2, result));
        return result;
    }
    @GetMapping(path = "cal/multiplication")
    public double multiplication(@RequestParam double number1, @RequestParam double number2) {
        double result = calculatorService.multiplication(number1,number2);
        /*System.out.println("The first number was introduced: " + calculationsMade.getFirstNumber());
        System.out.println("The second number was introduced: " + calculationsMade.getSecondNumber());*/
        publisher.publishEvent(
                new CalculationsMade(
                        this, methodNames, number1, number2, result));
        return result;
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
