package com.kodilla.good.patterns.Food2Door;

public class ExtraFoodShopProcess extends Process{
    @Override
    public boolean process(Order order) {
        System.out.println("ExtraFoodShopProcess");
        System.out.println(order);
        return true;
    }
}
