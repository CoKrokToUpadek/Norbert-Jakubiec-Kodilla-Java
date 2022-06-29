package com.kodilla.good.patterns.Food2Door;

public class GlutenFreeShopProcess extends Process{
    @Override
    public boolean process(Order order) {
        System.out.println(" GlutenFreeShopProcess");
        System.out.println(order);
        return true;
    }
}
