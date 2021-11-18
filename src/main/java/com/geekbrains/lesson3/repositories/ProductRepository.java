package com.geekbrains.lesson3.repositories;

import com.geekbrains.lesson3.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(List.of(
                new Product(1L, "Milk", 11),
                new Product(2L, "Water", 22),
                new Product(3L, "Apple", 33),
                new Product(4L, "Orange", 44)
        ));

    }
    public List<Product> getAllProduct() { // метод получает список всех продуктов
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

}
