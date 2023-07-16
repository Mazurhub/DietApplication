package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
//pozwala nam na proste korzystanie z baz danych
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
