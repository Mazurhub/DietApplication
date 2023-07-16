package com.example.demo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable UUID id, @RequestBody UpdateProduct updateProduct) {
        return service.updateProduct(id, updateProduct);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Product getProduct(@PathVariable UUID id) {
        return service.getProduct(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody CreateProduct createProduct) {
        return service.createProduct(createProduct);
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.geProducts();
    }
}



