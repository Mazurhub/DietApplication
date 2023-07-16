package com.example.demo.product;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class UpdateProduct {
    private UUID id;
    private String name;
}
