package com.example.demo.user.api.dto;

import com.example.demo.person_measurement.api.dto.PhysicalActivityLevel;

public record CreateUser(String userName,
                         String firstName,
                         String lastName,
                         String password,
                         String email,
                         String phoneNumber,
                         double weight,
                         double height,
                         int age,
                         String sex,
                         PhysicalActivityLevel palCoefficient){
}

