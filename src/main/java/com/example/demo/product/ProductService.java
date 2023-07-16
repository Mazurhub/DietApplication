package com.example.demo.product;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ProductService {
    Product createProduct(CreateProduct createProduct);
    Product getProduct(UUID id);
    List<Product> geProducts();
    Product updateProduct(UUID id, UpdateProduct updateProduct);
    Product updateProductFields(UUID id, Map<String, Object> fields);
}
