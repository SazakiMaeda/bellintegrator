package com.sazakimaeda.test5.service;

import com.sazakimaeda.test5.model.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Basket {
    ResponseEntity<Item> addProduct(Item item);
    ResponseEntity<Item> removeProduct(Long id);
    ResponseEntity<Item> updateProductQuantity(Long id, int quantity);
    void clear();
    ResponseEntity<List<Item>> getProducts();
    int getProductQuantity(String product);
}
