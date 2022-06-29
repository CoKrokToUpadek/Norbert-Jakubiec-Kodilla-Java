package com.kodilla.good.patterns.challenges.productOrderServiceChallengeResources;

public class ProductInBasket {

   private final GenericProduct product;
   private final int quantity;

    public ProductInBasket(GenericProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public GenericProduct getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ProductInBasket{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
