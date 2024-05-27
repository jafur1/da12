package ru.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.shop.model.ProductReturn;

import java.util.List;
import java.util.UUID;

public class ProductReturnController {

    @GetMapping
    public List<ProductReturn> getAll() {
        return productreturnService.findAll();
    }

    @GetMapping("/{id}")
    public ProductReturn getById(@PathVariable UUID id) {
        return productreturnService.getById(id);
    }

}
