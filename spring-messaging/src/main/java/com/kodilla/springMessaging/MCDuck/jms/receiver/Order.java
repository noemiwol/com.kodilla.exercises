package com.kodilla.springMessaging.MCDuck.jms.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Order {
    @JmsListener(containerFactory = "jmsFactory", destination = "acceptance-of-the-order")
    public void receive(String message) {
        System.out.println("Enter the name of the order that has been placed: " + message);
    }
}
