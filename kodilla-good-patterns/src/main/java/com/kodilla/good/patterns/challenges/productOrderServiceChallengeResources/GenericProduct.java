package com.kodilla.good.patterns.challenges.productOrderServiceChallengeResources;

public class GenericProduct {

    private final String productName;
    private final double productPrice;


    public GenericProduct(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return "GenericProduct{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
