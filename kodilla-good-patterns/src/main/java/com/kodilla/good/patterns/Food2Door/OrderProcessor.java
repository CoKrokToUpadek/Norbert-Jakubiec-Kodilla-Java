package com.kodilla.good.patterns.Food2Door;

import java.util.Map;


public class OrderProcessor {

    private final FoodManufacturers foodManufacturers;

    public OrderProcessor(FoodManufacturers foodManufacturers) {
        this.foodManufacturers = foodManufacturers;
    }

    public void processOrder(FoodManufacturer source, Order order) {

        FoodManufacturer tempFM = null;
        Process tempP = null;
        Product tempProduct=null;

        for (Map.Entry<FoodManufacturer, Process> entry : foodManufacturers.foodManufacturerProcessMap.entrySet()) {
            if (entry.getKey().equals(source)) {
                tempFM = entry.getKey();
                tempP = entry.getValue();
            }
        }

        assert tempFM != null;
        for (Product p:tempFM.getProductList()){
            if (p.getProductName().equals(order.getProduct())){
                tempProduct=p;
            }
        }


        System.out.println(tempFM.getName() + "/" + tempFM.getAddress());
        if (tempP.process(order, tempProduct)) {
            System.out.println("order processed correctly");
        } else {
            System.out.println("something went wrong");
        }

    }
}
