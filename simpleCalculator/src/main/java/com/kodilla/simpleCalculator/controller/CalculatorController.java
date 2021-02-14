package com.kodilla.simpleCalculator.controller;

import com.kodilla.simpleCalculator.domain.CalculatorDto;
import com.kodilla.simpleCalculator.event.CalculationsMade;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")

public class CalculatorController  implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    @PostMapping(path = "cal")
    public void simpleCalculator(@RequestBody CalculatorDto calculatorDto) {
        System.out.println("The first number was introduced: " + calculatorDto.getFirstNumber());
        System.out.println("The second number was introduced: " + calculatorDto.getSecondNumber());
        publisher.publishEvent(
                 new CalculationsMade(
                        this,
                        calculatorDto.getFirstNumber(),
                        calculatorDto.getSecondNumber()));
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
