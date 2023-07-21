package com.example.demo.persondetails.anthropometricindicator;

import java.util.UUID;

public interface AnthropometricIndicatorService {
    AnthropometricIndicator createAnthropometricIndicator(CreateAnthropometricIndicator createAnthropometricIndicator);
    AnthropometricIndicator calculateBMI(UUID id);
    AnthropometricIndicator calculatePPM(UUID id);


}
