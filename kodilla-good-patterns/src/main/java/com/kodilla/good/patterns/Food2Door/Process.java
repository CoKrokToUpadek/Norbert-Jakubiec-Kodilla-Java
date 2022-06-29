package com.kodilla.good.patterns.Food2Door;

public class Process {
    public boolean process(Order order){
        System.out.println("generic process");
        System.out.println(order.getProduct());
        return true;
    }
}
