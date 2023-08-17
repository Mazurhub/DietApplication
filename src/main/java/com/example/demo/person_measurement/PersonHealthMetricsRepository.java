package com.example.demo.person_measurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface PersonHealthMetricsRepository extends JpaRepository<PersonHealthMetricsEntity, UUID> {
}
