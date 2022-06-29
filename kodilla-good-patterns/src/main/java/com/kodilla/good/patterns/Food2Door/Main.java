package com.kodilla.good.patterns.Food2Door;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FoodManufacturers foodManufacturers=new FoodManufacturers();
        OrderProcessor orderProcessor=new OrderProcessor(foodManufacturers);

        GlutenFreeShopProcess GFSP=new GlutenFreeShopProcess();
        List<Product> glutenFreeShopProductList=new ArrayList<>();
        glutenFreeShopProductList.add(new Product("gluten free water",10));
        glutenFreeShopProductList.add(new Product("gluten free gluten",5));
        glutenFreeShopProductList.add(new Product("gluten free air",1));
        FoodManufacturer  GlutenFreeShop=new FoodManufacturer(" GlutenFreeShop","123",glutenFreeShopProductList);

        ExtraFoodShopProcess EFSP=new ExtraFoodShopProcess();
        List<Product> extraFoodShopProductList=new ArrayList<>();
        extraFoodShopProductList.add(new Product("turbo water",10));
        extraFoodShopProductList.add(new Product("turbo gluten",5));
        extraFoodShopProductList.add(new Product("turbo air",1));
        FoodManufacturer  extraFoodShop=new FoodManufacturer("extraFoodShop","324",extraFoodShopProductList);

        HealthyShopProcess HSP=new HealthyShopProcess();
        List<Product> healthyShopProductList=new ArrayList<>();
        healthyShopProductList.add(new Product("healthy water",10));
        healthyShopProductList.add(new Product("healthy  gluten",5));
        healthyShopProductList.add(new Product("healthy  air",1));
        FoodManufacturer  healthyFoodShop=new FoodManufacturer("healthyFoodShop","544",healthyShopProductList);



        foodManufacturers.addFoodManufacturer(GlutenFreeShop,GFSP);
        foodManufacturers.addFoodManufacturer(extraFoodShop,EFSP);
        foodManufacturers.addFoodManufacturer(healthyFoodShop,HSP);

        Order order=new Order("healthy  air",5);
        orderProcessor.processOrder(healthyFoodShop,order);


    }

}
