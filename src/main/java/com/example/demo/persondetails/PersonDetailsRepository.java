package com.example.demo.persondetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonDetailsRepository extends JpaRepository<PersonDetailsEntity, UUID> {
}