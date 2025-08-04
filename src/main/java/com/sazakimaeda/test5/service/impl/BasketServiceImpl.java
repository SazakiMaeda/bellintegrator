package com.sazakimaeda.test5.service.impl;

import com.sazakimaeda.test5.dao.BasketRepository;
import com.sazakimaeda.test5.handler.exception.BasketIsEmptyException;
import com.sazakimaeda.test5.handler.exception.ItemNoFoundException;
import com.sazakimaeda.test5.model.Item;
import com.sazakimaeda.test5.service.Basket;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements Basket {

    private final BasketRepository basketRepository;

    @Override
    public ResponseEntity<List<Item>> getProducts() {
        if (basketRepository.findAll().isEmpty()) {
            throw new BasketIsEmptyException();
        }
        return ResponseEntity.ok(basketRepository.findAll());
    }

    @Override
    public ResponseEntity<Item> addProduct(Item item) {
        basketRepository.save(item);
        return ResponseEntity.ok(item);
    }

    @Override
    public ResponseEntity<Item> removeProduct(Long id) {
        Item item = basketRepository.findById(id)
                .orElseThrow((ItemNoFoundException::new));
        basketRepository.delete(item);
        return ResponseEntity.ok(item);
    }

    @Override
    public ResponseEntity<Item> updateProductQuantity(Long id, int quantity) {
        Item findItem = basketRepository.findById(id)
                .orElseThrow((ItemNoFoundException::new));
        findItem.setQuantity(quantity);
        basketRepository.save(findItem);
        return ResponseEntity.ok(findItem);
    }

    @Override
    public void clear() {
        basketRepository.deleteAll();
        ResponseEntity.ok().build();
    }


    @Override
    public int getProductQuantity(String product) {
        Item findItem = basketRepository.findByProduct(product);
        if (findItem == null) throw new ItemNoFoundException();
        return findItem.getQuantity();
    }
}
