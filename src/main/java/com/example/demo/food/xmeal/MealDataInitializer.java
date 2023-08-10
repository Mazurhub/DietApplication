package com.example.demo.food.xmeal;

import com.example.demo.food.product.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MealDataInitializer implements CommandLineRunner {

    private final ProductService productService;
    private final MealRepository mealRepository;
    private final MealService mealService;
    private final MyProductRepository productRepository;

    public MealDataInitializer(ProductService productService, MealRepository mealRepository, MealService mealService, MyProductRepository productRepository) {
        this.productService = productService;
        this.mealRepository = mealRepository;
        this.mealService = mealService;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        // Pobierz wszystkie produkty z bazy danych
        List<ProductEntity> productsFromDatabase = productRepository.findAll();

        // Tworzymy przykładowy posiłek "Kotlet Schabowy z Ziemniakami oraz Mizerią"
        // Szukamy produktów na podstawie ich nazw
        ProductEntity kotletSchabowy = findProductByName(productsFromDatabase, "Kotlet_Schabowy");
        ProductEntity ziemniaki = findProductByName(productsFromDatabase, "Ziemniaki");
        ProductEntity ogorki = findProductByName(productsFromDatabase, "Ogórki");
        ProductEntity smietana = findProductByName(productsFromDatabase, "Śmietana");

        // Tworzymy posiłek i przypisujemy do niego stałe produkty
        List<Product> products = List.of(
                mapToProduct(kotletSchabowy),
                mapToProduct(ziemniaki),
                mapToProduct(ogorki),
                mapToProduct(smietana)
        );

        // Obliczamy sumę wartości kalorycznych, białka, tłuszczu i węglowodanów dla posiłku
        CreateMeal kotletSchabowyPosilek = new CreateMeal("Kotlet Schabowy z Ziemniakami oraz Mizerią", "Obiad", products);

        // Zapisujemy posiłek w bazie danych
        mealService.createMeal(kotletSchabowyPosilek);
    }

    // Metoda do przekształcania listy ProductEntity na listę Product
    private List<Product> mapToProducts(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }

    // Metoda do mapowania pojedynczego ProductEntity na Product
    private Product mapToProduct(ProductEntity productEntity) {
        if (productEntity == null) {
            return new Product("", 0.0, 0.0, 0.0, 0.0, 0.0);
        }

        return  new Product(
                productEntity.getName(),
                productEntity.getProductWeight(),
                productEntity.getKcal(),
                productEntity.getProteins(),
                productEntity.getFats(),
                productEntity.getCarbs()
        );
    }

    // Metoda do znalezienia produktu na podstawie jego nazwy
    private ProductEntity findProductByName(List<ProductEntity> products, String name) {
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}



