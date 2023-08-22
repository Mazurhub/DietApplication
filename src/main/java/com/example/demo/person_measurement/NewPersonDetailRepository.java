package com.example.demo.person_measurement;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
interface NewPersonDetailRepository extends JpaRepository<NewPersonDetailEntity, UUID> {
    @Query("SELECT npd FROM NewPersonDetailEntity npd " +
            "WHERE npd.personDetailsHistory.userId = :userId " +
            "ORDER BY npd.measurementDate DESC")
    List<NewPersonDetailEntity> findLatestByUserId(@Param("userId") UUID userId, Pageable pageable);

    default Optional<NewPersonDetailEntity> findLatestByUserId(@Param("userId") UUID userId) {
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Order.desc("measurementDate")));
        return findLatestByUserId(userId, pageable).stream().findFirst();
    }
}

