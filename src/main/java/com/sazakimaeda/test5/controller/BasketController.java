package com.sazakimaeda.test5.controller;

import com.sazakimaeda.test5.dto.QuantityRequest;
import com.sazakimaeda.test5.model.Item;
import com.sazakimaeda.test5.service.impl.BasketServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/basket")
public class BasketController {

    private final BasketServiceImpl basketService;

    @GetMapping
    public List<Item> getBasket() {
        return basketService.getProducts().getBody();
    }

    @GetMapping("/{product}")
    public ResponseEntity<Map<String, Integer>> getBasketQuantity(@PathVariable String product) {
        return ResponseEntity.ok(
                Map.of("quantity", basketService.getProductQuantity(product))
        );
    }

    @PostMapping("/add")
    public Item addProduct(@RequestBody Item item) {
        return basketService.addProduct(item).getBody();
    }

    @PutMapping("/{id}")
    public Item updateProduct(@PathVariable Long id,
                              @RequestBody @Valid QuantityRequest request) {
        return basketService.updateProductQuantity(id, request.getQuantity()).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> removeProduct(@PathVariable Long id) {
        return basketService.removeProduct(id);
    }

    @DeleteMapping("/clear")
    public void clearBasket() {
        basketService.clear();
    }
}
