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
    public AnthropometricIndicator getAnthropometricIndicator(UUID id) {
        AnthropometricIndicatorEntity anthropometricIndicatorEntity = repository.findById(id).get();
        return mapToAnthropometricIndicator(anthropometricIndicatorEntity);
    }
    @Override
    public AnthropometricIndicator calculateBMI(UUID id) {
        AnthropometricIndicatorEntity anthropometricIndicatorEntity = repository.findById(id).orElse(null);

        String bmi = calculateBMIValue(anthropometricIndicatorEntity.getWeight(), anthropometricIndicatorEntity.getHeight());
        anthropometricIndicatorEntity.setBmi(bmi);
        repository.save(anthropometricIndicatorEntity);

        AnthropometricIndicator anthropometricIndicator = mapToAnthropometricIndicator(anthropometricIndicatorEntity);
        anthropometricIndicator.setBmi(bmi);
        return anthropometricIndicator;
    }

    @Override
    public AnthropometricIndicator calculatePPM(UUID id) {
        AnthropometricIndicatorEntity anthropometricIndicatorEntity = repository.findById(id).orElse(null);

        String ppm = calculatePMMValue(anthropometricIndicatorEntity.getWeight(), anthropometricIndicatorEntity.getHeight(), anthropometricIndicatorEntity.getAge(), anthropometricIndicatorEntity.getSex());
        anthropometricIndicatorEntity.setPpm(ppm);
        repository.save(anthropometricIndicatorEntity);

        AnthropometricIndicator anthropometricIndicator = mapToAnthropometricIndicator(anthropometricIndicatorEntity);
        anthropometricIndicator.setPpm(ppm);
        return anthropometricIndicator;
    }

    @Override
    public AnthropometricIndicator calculateCPM(UUID id) {
        AnthropometricIndicatorEntity anthropometricIndicatorEntity = repository.findById(id).orElse(null);

        double ppm = Double.parseDouble(anthropometricIndicatorEntity.getPpm().replace(",", "."));
        EnumPalCoefficient palCoefficient = anthropometricIndicatorEntity.getEnumPalCoefficient();
        double cpm = switch (palCoefficient) {
            case PAL_1 -> ppm * 1.2;
            case PAL_2 -> ppm * 1.4;
            case PAL_3 -> ppm * 1.6;
            case PAL_4 -> ppm * 1.8;
            case PAL_5 -> ppm * 2.0;
        };

        DecimalFormat df = new DecimalFormat("#.##");
        String roundedNumberCPM = df.format(cpm);

        anthropometricIndicatorEntity.setCpm(roundedNumberCPM);
        repository.save(anthropometricIndicatorEntity);

        AnthropometricIndicator anthropometricIndicator = mapToAnthropometricIndicator(anthropometricIndicatorEntity);
        anthropometricIndicator.setCpm(roundedNumberCPM);

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
            return roundedNumberBMI + " " + "You are underweight: your BMI score is under 18,5. You are outside the healthy BMI range (25 - 30).";
        }
        else if (bmi < 25) {
            return roundedNumberBMI + " " + "You are Normal: your BMI score is beetween 18,5 - 25,0";
        }
        else if (bmi < 30) {
            return roundedNumberBMI + " " + "You are  Overweight: your BMI score is beetween 25,0 - 30,0. You are outside the healthy BMI range (25 - 30)";
        }
        else {
            return roundedNumberBMI + " " + "You are  Obese: your BMI score is above 30,0. You are outside the healthy BMI range (25 - 30)";
        }
    }

    private AnthropometricIndicatorEntity mapToAnthropometricIndicatorEntity (CreateAnthropometricIndicator createAnthropometricIndicator) {
        AnthropometricIndicatorEntity anthropometricIndicatorEntity = new AnthropometricIndicatorEntity();
        anthropometricIndicatorEntity.setId(UUID.randomUUID());
        anthropometricIndicatorEntity.setAge(createAnthropometricIndicator.getAge());
        anthropometricIndicatorEntity.setWeight(createAnthropometricIndicator.getWeight());
        anthropometricIndicatorEntity.setHeight(createAnthropometricIndicator.getHeight());
        anthropometricIndicatorEntity.setSex(createAnthropometricIndicator.getSex());
        anthropometricIndicatorEntity.setEnumPalCoefficient(createAnthropometricIndicator.getEnumPalCoefficient());
        return anthropometricIndicatorEntity;
    }
    private AnthropometricIndicator mapToAnthropometricIndicator (AnthropometricIndicatorEntity anthropometricIndicatorEntity) {
        AnthropometricIndicator anthropometricIndicator = new AnthropometricIndicator();
        anthropometricIndicator.setId(anthropometricIndicatorEntity.getId());
        anthropometricIndicator.setAge(anthropometricIndicatorEntity.getAge());
        anthropometricIndicator.setWeight(anthropometricIndicatorEntity.getWeight());
        anthropometricIndicator.setHeight(anthropometricIndicatorEntity.getHeight());
        anthropometricIndicator.setSex(anthropometricIndicatorEntity.getSex());
        anthropometricIndicator.setEnumPalCoefficient(anthropometricIndicatorEntity.getEnumPalCoefficient());
        anthropometricIndicator.setBmi(anthropometricIndicatorEntity.getBmi());
        anthropometricIndicator.setPpm(anthropometricIndicatorEntity.getPpm());
        anthropometricIndicator.setCpm(anthropometricIndicatorEntity.getCpm());
        return anthropometricIndicator;
    }
}
