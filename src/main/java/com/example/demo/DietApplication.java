package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DietApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(DietApplication.class, args);
        ProductRepository productRepository =
                configurableApplicationContext.getBean(ProductRepository.class);

        Product pomidor = new Product("pomidor", 11.0,12.0,13.0,14.0);
        productRepository.save(pomidor);

    }

}
