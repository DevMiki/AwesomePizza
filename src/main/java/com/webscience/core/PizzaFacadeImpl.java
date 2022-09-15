package com.webscience.core;

import com.webscience.core.model.Pizza;
import com.webscience.core.model.PizzaState;
import com.webscience.core.repository.InMemoryMapRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PizzaFacadeImpl implements PizzaFacade {

    @Override
    public int makePizza(Integer orderNum) throws InterruptedException {
        Pizza pizza = new Pizza(LocalDate.now(), orderNum);
        pizza.setPizzaState(PizzaState.IN_LAVORAZIONE);
        InMemoryMapRepository.ordersToProcess.add(pizza);
        InMemoryMapRepository.pizzaInProgress.put(orderNum, pizza);
        System.out.println("Grazie per il suo ordine, faccia pure una chiamata GET alla nostra API per conoscere lo stato della sua pizza!");
        Pizzaiolo.GIGI.finishPizza();
        return pizza.getId();
    }

    @Override
    public String getPizzaStatus(Integer pizzaId) {
        Optional<Pizza> pizza = Optional.ofNullable(InMemoryMapRepository.pizzaInProgress.get(pizzaId));
        return String.format("La sua pizza è: %s", pizza.isEmpty() ? "andata dispersa" : pizza.get().getPizzaState());
    }


}
