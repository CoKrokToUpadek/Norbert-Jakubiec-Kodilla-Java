package com.kodilla.good.patterns.Food2Door;

public class Order {

    private String product;
    private int quantity;

    public Order(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product='" + product + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
