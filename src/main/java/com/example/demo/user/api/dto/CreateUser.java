package com.example.demo.user.api.dto;


public record CreateUser(String userName, String firstName, String lastName, String password, String email, String phoneNumber) {
}

