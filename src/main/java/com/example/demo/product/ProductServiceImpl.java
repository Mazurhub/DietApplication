package com.example.demo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public Product createProduct(CreateProduct createProduct) {
        ProductEntity productEntity = mapToProductEntity(createProduct);
        ProductEntity saveProductEntity = repository.save(productEntity);
        return mapToProduct(saveProductEntity);
    }

    @Override
    public Product getProduct(UUID id) {
        ProductEntity productEntity = repository.findById(id).get();
        return mapToProduct(productEntity);
    }

    @Override
    public List<Product> geProducts() {
        return repository.findAll()
                .stream()
                .map(this::mapToProduct)
                .toList();
    }

    @Override
    public Product updateProduct(UUID id, UpdateProduct updateProduct) {
        ProductEntity existingProduct = repository.findById(id).get();
        existingProduct.setName(updateProduct.getName());
        return mapToProduct(repository.save(existingProduct));
    }

    @Override
    public Product updateProductFields(UUID id, Map<String, Object> fields) {
        return null;
    }

    private ProductEntity mapToProductEntity(CreateProduct createProduct) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(UUID.randomUUID());
        productEntity.setName(createProduct.getName());
        return productEntity;
    }

    private Product mapToProduct(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        return product;
    }
}
