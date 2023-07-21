package com.example.demo.persondetails.anthropometricindicator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RequiredArgsConstructor
@RestController
@RequestMapping("/persondetails")
public class AnthropometricIndicatorController {
    private final AnthropometricIndicatorService service;

    @PostMapping
    public AnthropometricIndicator createAnthropometricIndicator(@RequestBody CreateAnthropometricIndicator createAnthropometricIndicator) {
        return service.createAnthropometricIndicator(createAnthropometricIndicator);
    }

    @GetMapping("/calculate-bmi/{id}")
    public AnthropometricIndicator calculateBMI(@PathVariable UUID id) {
        return service.calculateBMI(id);
    }

    @GetMapping("/calculate-ppm/{id}")
    public AnthropometricIndicator calculatePPM(@PathVariable UUID id) {
        return service.calculatePPM(id);
    }
}
