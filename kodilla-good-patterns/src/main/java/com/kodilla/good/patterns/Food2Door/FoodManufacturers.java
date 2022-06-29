package com.kodilla.good.patterns.Food2Door;

import java.util.HashMap;
import java.util.Map;

public class FoodManufacturers {

    Map<FoodManufacturer, Process>  foodManufacturerProcessMap;

    public FoodManufacturers() {
        foodManufacturerProcessMap=new HashMap<>();
    }

    public void addFoodManufacturer(FoodManufacturer f1, Process p){
        foodManufacturerProcessMap.put(f1,p);
    }

    public Map<FoodManufacturer, Process> getFoodManufacturerProcessMap() {
        return foodManufacturerProcessMap;
    }
}
