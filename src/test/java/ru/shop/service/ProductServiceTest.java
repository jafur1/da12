package ru.shop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.shop.exception.EntityNotFoundException;
import ru.shop.model.Customer;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.ProductRepository;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    private final ProductRepository repository = Mockito.mock();
    private final ProductService productService = new ProductService(repository);

    @Test
    public void shouldGetCustomer() {
        // given
        UUID productId = UUID.randomUUID();
        Product mockedProduct = new Product(productId, "name", 10, ProductType.SERVICE);
        when(repository.findById(productId)).thenReturn(Optional.of(mockedProduct));

        // when
        Product product = productService.getById(productId);

        // then
        Assertions.assertEquals(mockedProduct, product);
    }

    @Test
    public void shouldThrowWhenCustomerNotFound() {
        // then
        Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> productService.getById(UUID.randomUUID())
        );
    }
}
