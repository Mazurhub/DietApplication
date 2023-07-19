package com.example.demo.persondetails.anthropometricindicator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnthropometricIndicatorRepository extends JpaRepository<AnthropometricIndicatorEntity, UUID> {
}
