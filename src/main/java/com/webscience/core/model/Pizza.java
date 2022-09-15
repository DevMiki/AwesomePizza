package com.webscience.core.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;

@Data
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate orderDate;
    private int orderNum;
    private PizzaState pizzaState;

    public Pizza(LocalDate orderDate, int orderNum){
        this.orderDate = orderDate;
        this.orderNum = orderNum;
    }
}
