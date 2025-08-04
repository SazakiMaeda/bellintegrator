package com.sazakimaeda.test5.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class QuantityRequest {

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
}
