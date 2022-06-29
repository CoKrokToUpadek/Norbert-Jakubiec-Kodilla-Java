package com.kodilla.good.patterns.Food2Door;

public class ExtraFoodShopProcess extends Process{
    @Override
    public boolean process(Order order,Product product) {
        System.out.println("ExtraFoodShopProcess");
        System.out.println(order+" was ordered");
        System.out.println("price for one of:"+order.getProduct()+" is equal to:"+ product.getProductPrice());
        System.out.println("sum to pay is equal to:"+order.getQuantity()*product.getProductPrice());
        return true;
    }
}
