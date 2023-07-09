package com.tms.shop.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Cart implements Serializable {

    private List<Product> products = new ArrayList<>();
    private int totalPrice = 0;


    public void addProduct(Product productId) {
        products.add(productId);
    }

    public void deleteProduct(Product productId) {
        products.remove(productId);
    }

    public void clear() {
        products.clear();
    }
}