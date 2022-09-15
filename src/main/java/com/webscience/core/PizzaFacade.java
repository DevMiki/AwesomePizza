package com.webscience.core;

import org.springframework.stereotype.Service;

@Service
public interface PizzaFacade {
    int makePizza(Integer orderId) throws InterruptedException;
    String getPizzaStatus(Integer pizzaId);
}
