package com.webscience.core.repository;

import com.webscience.core.model.Pizza;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryMapRepository {

    public static Queue<Pizza> ordersToProcess = new PriorityQueue<>(Comparator.comparing(Pizza::getOrderDate));
    public static Map<Integer, Pizza> pizzaInProgress = new HashMap<>();
}
