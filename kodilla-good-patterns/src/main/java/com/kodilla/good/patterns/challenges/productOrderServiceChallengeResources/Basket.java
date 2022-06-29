package com.kodilla.good.patterns.challenges.productOrderServiceChallengeResources;

import com.sun.java.accessibility.util.EventID;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private List<ProductInBasket> basket;

    public Basket() {
        basket = new ArrayList<>();
    }

    public void addProductToBasket(GenericProduct product, int quantity) {
        basket.add(new ProductInBasket(product, quantity));
    }

    public void removeProductFromBasketByName(String productName) {
        basket = basket.stream().filter(e -> !(e.getProduct().getProductName().equals(productName))).collect(Collectors.toList());
    }

    public void generateBasket(Auction auction) {
        addProductToBasket(auction.getProductsOffered().getProductList().get(1), 1);
    }

    public void clear() {
        basket.clear();
    }

    public InvoiceDTO generateInvoice() {
        String invoice = "";
        double sum = 0;
        for (int i = 0; i < basket.size(); i++) {
            invoice += basket.get(i).getProduct() + "/" + basket.get(i).getQuantity() + "\n";
            sum += basket.get(i).getProduct().getProductPrice() * basket.get(i).getQuantity();
        }
        invoice += "sum:" + sum;
        return new InvoiceDTO(invoice, sum);
    }

}
