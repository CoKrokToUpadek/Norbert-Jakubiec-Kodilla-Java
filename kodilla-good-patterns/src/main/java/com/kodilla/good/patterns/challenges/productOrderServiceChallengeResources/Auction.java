package com.kodilla.good.patterns.challenges.productOrderServiceChallengeResources;

public class Auction {
    private final String owner;
    private final ProductList productsOffered;

    public Auction(String owner, ProductList productsOffered) {
        this.owner = owner;
        this.productsOffered = productsOffered;
        productsOffered.initialiseProductList();
    }

    public String getOwner() {
        return owner;
    }

    public ProductList getProductsOffered() {
        return productsOffered;
    }
}
