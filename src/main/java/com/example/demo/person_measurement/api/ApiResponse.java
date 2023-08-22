package com.example.demo.person_measurement.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class ApiResponse {
    private String status;
    private String message;
}
