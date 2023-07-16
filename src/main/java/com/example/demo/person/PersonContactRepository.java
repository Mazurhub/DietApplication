package com.example.demo.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface PersonContactRepository extends JpaRepository <PersonContactEntity, UUID> {
}
