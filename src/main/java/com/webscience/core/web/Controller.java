package com.webscience.core.web;

import com.webscience.core.PizzaFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/orders")
@RestController
public class Controller {

    @Autowired
    PizzaFacadeImpl pizzaFacade;

    @GetMapping
    public String getPizzaStatus(@RequestParam Integer orderId){
        return pizzaFacade.getPizzaStatus(orderId);
    }

    @PostMapping
    public int makePizza(@RequestBody Integer orderNum) throws InterruptedException {
        return pizzaFacade.makePizza(orderNum);
    }
}
