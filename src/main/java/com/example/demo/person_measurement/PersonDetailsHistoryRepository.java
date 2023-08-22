package com.example.demo.person_measurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface PersonDetailsHistoryRepository extends JpaRepository<PersonDetailsHistoryEntity, UUID> {
    Optional<PersonDetailsHistoryEntity> findByUserId(UUID userId);
}
