package com.example.demo.persondetails.anthropometricindicator;

public interface AnthropometricIndicatorService {
    AnthropometricIndicator createAnthropometricIndicator(CreateAnthropometricIndicator createAnthropometricIndicator);
    String calculateBMI(CreateAnthropometricIndicator createAnthropometricIndicator);

}
