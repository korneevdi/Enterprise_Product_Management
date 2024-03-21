package com.example.manager.controller.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewProductPayload(
        @NotNull(message = "{catalogue.product.create.errors.title_is_invalid}")
        @Size(min = 2, max = 50, message = "{catalogue.product.create.errors.title_size_is_invalid}")
        String title,
        @Size(max = 1500, message = "{catalogue.product.create.errors.details_size_is_invalid}")
        String details) {
}
