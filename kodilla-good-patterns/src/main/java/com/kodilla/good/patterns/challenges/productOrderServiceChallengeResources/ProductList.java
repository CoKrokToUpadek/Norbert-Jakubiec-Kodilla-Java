package com.kodilla.good.patterns.challenges.productOrderServiceChallengeResources;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private final List<GenericProduct> productList;

    public ProductList() {
        productList = new ArrayList<>();
    }

    public void addProduct(GenericProduct product) {
        productList.add(product);
    }


    public void initialiseProductList() {
        addProduct(new GenericProduct("toy car", 10.2));
        addProduct(new GenericProduct("printer", 100));
        addProduct(new GenericProduct("keyboard", 50));
    }

    public List<GenericProduct> getProductList() {
        return productList;
    }
}
