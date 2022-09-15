package com.webscience.core;

import com.webscience.core.model.Pizza;
import com.webscience.core.model.PizzaState;
import com.webscience.core.repository.InMemoryMapRepository;

//Usage of ENUM as a mean to achieve Singleton Pattern
public enum Pizzaiolo {

    GIGI;

    public void finishPizza() throws InterruptedException {
        Pizza currentPizza = InMemoryMapRepository.ordersToProcess.poll();
        System.out.println("Bene, molto bene, ora la faccio bella rotonda");
        Thread.sleep(5000);
        System.out.println("Perfetto ora posso infornarla");
        currentPizza.setPizzaState(PizzaState.INFORNATA);
        Thread.sleep(5000);
        currentPizza.setPizzaState(PizzaState.COTTA);
        System.out.println("Un'altra pizza stupenda fatta da me modestamente");
    }

}
