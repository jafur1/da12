package ru.shop.service;

import ru.shop.exception.BadProductReturnCountException;
import ru.shop.exception.EntityNotFoundException;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.model.ProductReturn;
import ru.shop.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

public class ProductReturnService {

    private ProductRepository repository;

    public void add(Order order, long count) {
        if (count <= 0) {
            throw new BadProductReturnCountException();
        }
    }
    public List<ProductReturn> findAll(){
        return repository.findAll();
    }
    public ProductReturn findById(UUID id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
