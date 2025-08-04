package com.sazakimaeda.test5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "product", unique = true)
    @NotBlank(message = "Product name is required")
    @Size(max = 100, message = "Product name must be less than 100 characters")
    String product;

    @Column(name = "quantity", nullable = false)
    @Min(value = 1, message = "Quantity must be at least 1")
    int quantity;

    @Column(name = "price", nullable = false)
    @Min(value = 1, message = "Price cannot be negative or <= 0")
    int price;

}
