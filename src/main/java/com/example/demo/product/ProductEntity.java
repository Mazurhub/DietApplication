package com.example.demo.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Entity
@Getter
@Setter

public class ProductEntity {
    @Id
    private UUID id;
    private String name;
}
