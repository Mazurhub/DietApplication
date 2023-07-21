package com.example.demo.persondetails.anthropometricindicator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
    public AnthropometricIndicator calculateBMI(UUID id) {
        AnthropometricIndicatorEntity anthropometricIndicatorEntity = repository.findById(id).orElse(null);

        if (anthropometricIndicatorEntity == null) {
            throw new IllegalArgumentException("Person with ID " + id + " not found.");
        }

        String bmi = calculateBMIValue(anthropometricIndicatorEntity.getWeight(), anthropometricIndicatorEntity.getHight());
        anthropometricIndicatorEntity.setBmi(bmi);
        repository.save(anthropometricIndicatorEntity);

        AnthropometricIndicator anthropometricIndicator = mapToAnthropometricIndicator(anthropometricIndicatorEntity);
        anthropometricIndicator.setBmi(bmi);
        return anthropometricIndicator;
    }

    @Override
    public AnthropometricIndicator calculatePPM(UUID id) {
        AnthropometricIndicatorEntity anthropometricIndicatorEntity = repository.findById(id).orElse(null);

        if (anthropometricIndicatorEntity == null) {
            throw new IllegalArgumentException("Person with ID " + id + " not found.");
        }

        String ppm = calculatePMMValue(anthropometricIndicatorEntity.getWeight(), anthropometricIndicatorEntity.getHight(), anthropometricIndicatorEntity.getAge(), anthropometricIndicatorEntity.getSex());
        anthropometricIndicatorEntity.setPpm(ppm);
        repository.save(anthropometricIndicatorEntity);

        AnthropometricIndicator anthropometricIndicator = mapToAnthropometricIndicator(anthropometricIndicatorEntity);
        anthropometricIndicator.setPpm(ppm);
        return anthropometricIndicator;
    }

    private String calculatePMMValue(double weight, double height, int age, String sex) {
        double ppm;
        if (sex.equals("Women")) {
            ppm = 655.1 + (9.563 * weight + (1.85 * height) - (4.676 * age));
        }else if (sex.equals("Men")) {
            ppm = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
        }else {
            throw new IllegalArgumentException("Incorrect sex, please check and try again");
        }
        DecimalFormat df = new DecimalFormat("#.##");
        String roundedNumberPPM = df.format(ppm);
        return roundedNumberPPM;
    }

    private String calculateBMIValue(double weight, double height) {
        // Przekształcenie wzrostu z centymetrów na metry
        double heightInMeters = height / 100.0;
        double bmi = weight / (heightInMeters * heightInMeters);

        DecimalFormat df = new DecimalFormat("#.##");
        String roundedNumberBMI = df.format(bmi);

        if (bmi < 18.5) {
            return roundedNumberBMI + " " + "You are underweight: your BMI score is under 18,5" ;
        }
        else if (bmi < 25) {
            return roundedNumberBMI + " " + "You are Normal: your BMI score is beetween 18,5 - 25,0";
        }
        else if (bmi < 30) {
            return roundedNumberBMI + " " + "You are  Overweight: your BMI score is beetween 25,0 - 30,0";
        }
        else {
            return roundedNumberBMI + " " + "You are  Obese: your BMI score is above 30,0";
        }
    }

    private AnthropometricIndicatorEntity mapToAnthropometricIndicatorEntity (CreateAnthropometricIndicator createAnthropometricIndicator) {
        AnthropometricIndicatorEntity anthropometricIndicatorEntity = new AnthropometricIndicatorEntity();
        anthropometricIndicatorEntity.setId(UUID.randomUUID());
        anthropometricIndicatorEntity.setAge(createAnthropometricIndicator.getAge());
        anthropometricIndicatorEntity.setWeight(createAnthropometricIndicator.getWeight());
        anthropometricIndicatorEntity.setHight(createAnthropometricIndicator.getHight());
        anthropometricIndicatorEntity.setSex(createAnthropometricIndicator.getSex());
        return anthropometricIndicatorEntity;
    }
    private AnthropometricIndicator mapToAnthropometricIndicator (AnthropometricIndicatorEntity anthropometricIndicatorEntity) {
        AnthropometricIndicator anthropometricIndicator = new AnthropometricIndicator();
        anthropometricIndicator.setId(anthropometricIndicatorEntity.getId());
        anthropometricIndicator.setAge(anthropometricIndicatorEntity.getAge());
        anthropometricIndicator.setWeight(anthropometricIndicatorEntity.getWeight());
        anthropometricIndicator.setHight(anthropometricIndicatorEntity.getHight());
        anthropometricIndicator.setSex(anthropometricIndicatorEntity.getSex());
        return anthropometricIndicator;
    }
}
