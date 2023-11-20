package com.example.demo.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, UUID> {
}
