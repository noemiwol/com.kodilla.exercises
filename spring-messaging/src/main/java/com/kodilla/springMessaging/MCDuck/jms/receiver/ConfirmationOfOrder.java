package com.kodilla.springMessaging.MCDuck.jms.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationOfOrder {
    @JmsListener(containerFactory = "jmsFactory", destination = "acceptance-of-the-order")
    public void receive(String message) {
        System.out.println("Confirmation of order : " + message);
    }
    public void acceptedOrder(String message) {

    }
}
