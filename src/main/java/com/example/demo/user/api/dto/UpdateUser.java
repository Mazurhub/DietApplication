package com.example.demo.user.api.dto;

import java.util.UUID;

public record UpdateUser(UUID userId, String userName, String firstName, String lastName, String password, String email, String phoneNumber) {
}

