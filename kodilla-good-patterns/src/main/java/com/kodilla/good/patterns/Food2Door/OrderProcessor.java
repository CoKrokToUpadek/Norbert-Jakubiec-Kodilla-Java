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

        for (Map.Entry<FoodManufacturer, Process> entry : foodManufacturers.foodManufacturerProcessMap.entrySet()) {
            if (entry.getKey().equals(source)) {
                tempFM = entry.getKey();
                tempP = entry.getValue();
            }
        }
        assert tempFM != null;
        System.out.println(tempFM.getName() + "/" + tempFM.getAddress());
        if (tempP.process(order)) {
            System.out.println("order processed correctly");
        } else {
            System.out.println("something went wrong");
        }

    }
}
