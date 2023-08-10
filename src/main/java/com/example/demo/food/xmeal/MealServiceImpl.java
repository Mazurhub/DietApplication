package com.example.demo.food.xmeal;

import com.example.demo.food.product.Product;
import com.example.demo.food.product.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository repository;

    @Autowired
    public MealServiceImpl(MealRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Meal createMeal(CreateMeal createMeal) {
        List<ProductEntity> productEntities = createMeal.getProducts().stream()
                .map(this::mapToProductEntity) // Używamy mapToProductEntity do konwersji Product na ProductEntity
                .collect(Collectors.toList());

        MealEntity mealEntity = mapToMealEntity(createMeal, productEntities);
        MealEntity savedMealEntity = repository.save(mealEntity);

        return mapToMeal(savedMealEntity);
    }

    private MealEntity mapToMealEntity(CreateMeal createMeal, List<ProductEntity> productEntities) {
        MealEntity mealEntity = new MealEntity();
        mealEntity.setName(createMeal.getName());
        mealEntity.setCategory(createMeal.getCategory());
        mealEntity.setProducts(productEntities); // Ustaw listę produktów dla posiłku
        mealEntity.setTotalKcal(createMeal.getTotalKcal());
        mealEntity.setTotalProteins(createMeal.getTotalProteins());
        mealEntity.setTotalFats(createMeal.getTotalFats());
        mealEntity.setTotalCarbs(createMeal.getTotalCarbs());
        return mealEntity;
    }

    private ProductEntity mapToProductEntity(Product product) {
        return new ProductEntity(
                product.getName(),
                product.getKcal(),
                product.getProductWeight(),
                product.getProteins(),
                product.getFats(),
                product.getCarbs()
        );
    }

    private Meal mapToMeal(MealEntity mealEntity) {
        List<Product> products = mealEntity.getProducts().stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());

        return new Meal(
                mealEntity.getName(),
                mealEntity.getCategory(),
                products,
                mealEntity.getTotalKcal(),
                mealEntity.getTotalProteins(),
                mealEntity.getTotalFats(),
                mealEntity.getTotalCarbs()
        );
    }

    public Product mapToProduct(ProductEntity productEntity) {
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
