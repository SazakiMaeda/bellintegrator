package com.sazakimaeda.test5.dao;

import com.sazakimaeda.test5.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Item, Long> {
    Item findByProduct(String product);
}
