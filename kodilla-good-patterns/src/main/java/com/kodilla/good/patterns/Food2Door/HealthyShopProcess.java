package com.kodilla.good.patterns.Food2Door;

public class HealthyShopProcess extends Process{

    @Override
    public boolean process(Order order) {
        System.out.println("HealthyShopProcess");
        System.out.println(order);
        return true;
    }
}
