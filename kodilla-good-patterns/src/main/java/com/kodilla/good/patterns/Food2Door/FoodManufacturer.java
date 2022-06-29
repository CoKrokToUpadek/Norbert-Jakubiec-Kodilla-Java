package com.kodilla.good.patterns.Food2Door;

import java.util.List;
import java.util.Objects;

public class FoodManufacturer {
    private final String name;
    private final String address;
    private List<Product> productList;

    public FoodManufacturer(String name, String address ,List<Product> productList) {
        this.name = name;
        this.address = address;
        this.productList = productList;
    }

    public void addProductToList(Product product){
        productList.add(product);
    }

    public void removeProductFromList(Product product){
        productList.remove(product);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodManufacturer that = (FoodManufacturer) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
