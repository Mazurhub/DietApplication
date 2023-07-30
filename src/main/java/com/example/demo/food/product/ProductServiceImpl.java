package com.example.demo.food.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
    private final MyProductRepository repository;

    @Override
    @Transactional // Dodaj adnotację @Transactional, aby zapewnić poprawne zapisanie produktów do bazy danych
    public Product createProduct(CreateProduct createProduct) {
        ProductEntity productEntity = mapToProductEntity(createProduct);
        ProductEntity savedProductEntity = repository.save(productEntity);
        return mapToProduct(savedProductEntity);
    }

    private ProductEntity mapToProductEntity(CreateProduct createProduct) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(createProduct.getName());
        productEntity.setProductWeight(createProduct.getProductWeight());
        productEntity.setKcal(createProduct.getKcal());
        productEntity.setProteins(createProduct.getProteins());
        productEntity.setFats(createProduct.getFats());
        productEntity.setCarbs(createProduct.getCarbs());
        return productEntity;
    }

    private Product mapToProduct(ProductEntity productEntity) {
        return new Product(
                productEntity.getName(),
                productEntity.getProductWeight(),
                productEntity.getKcal(),
                productEntity.getProteins(),
                productEntity.getFats(),
                productEntity.getCarbs()
        );
    }
}
