package com.example.demo.persondetails.anthropometricindicator;

import com.example.demo.person.Person;
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
}
