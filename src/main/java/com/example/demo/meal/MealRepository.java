package com.example.demo.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
interface MealRepository extends JpaRepository<MealEntity, UUID> {
}
