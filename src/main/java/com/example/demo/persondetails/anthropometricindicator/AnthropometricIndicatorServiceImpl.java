package com.example.demo.persondetails.anthropometricindicator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AnthropometricIndicatorServiceImpl implements AnthropometricIndicatorService {
    private final AnthropometricIndicatorRepository repository;

    @Override
    public AnthropometricIndicator createAnthropometricIndicator(CreateAnthropometricIndicator createAnthropometricIndicator) {
        AnthropometricIndicatorEntity anthropometricIndicatorEntity = mapToAnthropometricIndicatorEntity(createAnthropometricIndicator);
        AnthropometricIndicatorEntity savedAnthropometricIndicatorEntity = repository.save(anthropometricIndicatorEntity);
        return mapToAnthropometricIndicator(savedAnthropometricIndicatorEntity);
    }

    @Override
    public String calculateBMI(CreateAnthropometricIndicator createAnthropometricIndicator) {
        double BMI = createAnthropometricIndicator.getWeight() / (createAnthropometricIndicator.getHight()* createAnthropometricIndicator.getHight());
        if (BMI < 18.5) {
            return "Underweight";
        }
        else if (BMI < 25) {
            return "Normal";
        }
        else if (BMI < 30) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }

    private AnthropometricIndicatorEntity mapToAnthropometricIndicatorEntity (CreateAnthropometricIndicator createAnthropometricIndicator) {
        AnthropometricIndicatorEntity anthropometricIndicatorEntity = new AnthropometricIndicatorEntity();
        anthropometricIndicatorEntity.setId(UUID.randomUUID());
        anthropometricIndicatorEntity.setWeight(createAnthropometricIndicator.getWeight());
        anthropometricIndicatorEntity.setHight(createAnthropometricIndicator.getHight());
        anthropometricIndicatorEntity.setBmi(createAnthropometricIndicator.getBmi());
        return anthropometricIndicatorEntity;
    }
    private AnthropometricIndicator mapToAnthropometricIndicator (AnthropometricIndicatorEntity anthropometricIndicatorEntity) {
        AnthropometricIndicator anthropometricIndicator = new AnthropometricIndicator();
        anthropometricIndicator.setId(anthropometricIndicatorEntity.getId());
        anthropometricIndicator.setWeight(anthropometricIndicatorEntity.getWeight());
        anthropometricIndicator.setHight(anthropometricIndicatorEntity.getHight());
        anthropometricIndicator.setBmi(anthropometricIndicator.getBmi());
        return anthropometricIndicator;
    }
}
