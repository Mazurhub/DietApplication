package com.example.demo.persondetails;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PersonDetailsServiceImpl implements PersonDetailsService {
    private final PersonDetailsRepository repository;


    @Override
    public PersonDetails createPersonDetails(CreatePersonDetails createPersonDetails) {
        PersonDetailsEntity personDetailsEntity = mapToPersonDetailsEntity(createPersonDetails);
        PersonDetailsEntity savedPersonDetailsEntity = repository.save(personDetailsEntity);
        return mapToPersonDetails(savedPersonDetailsEntity);
    }
    @Override
    public PersonDetails getPersonDetails(UUID id) {
        PersonDetailsEntity personDetailsEntity = repository.findById(id).get();
        return mapToPersonDetails(personDetailsEntity);
    }

    @Override
    public PersonDetails calculateBMI(UUID id) {
        PersonDetailsEntity personDetailsEntity = repository.findById(id).orElse(null);

        String bmi = calculateBMIValue(personDetailsEntity.getWeight(), personDetailsEntity.getHeight());
        personDetailsEntity.setBmi(bmi);
        repository.save(personDetailsEntity);

        PersonDetails personDetails = mapToPersonDetails(personDetailsEntity);
        personDetails.setBmi(bmi);
        return personDetails;
    }

    @Override
    public PersonDetails calculatePPM(UUID id) {
        PersonDetailsEntity personDetailsEntity = repository.findById(id).orElse(null);

        String ppm = calculatePMMValue(personDetailsEntity.getWeight(), personDetailsEntity.getHeight(), personDetailsEntity.getAge(), personDetailsEntity.getSex());
        personDetailsEntity.setPpm(ppm);
        repository.save(personDetailsEntity);

        PersonDetails personDetails = mapToPersonDetails(personDetailsEntity);
        personDetails.setPpm(ppm);
        return personDetails;
    }
    @Override
    public PersonDetails calculateCPM(UUID id) {
        PersonDetailsEntity personDetailsEntity = repository.findById(id).orElse(null);

        double ppm = Double.parseDouble(personDetailsEntity.getPpm().replace(",", "."));
        EnumPalCoefficient palCoefficient = personDetailsEntity.getEnumPalCoefficient();
        double cpm = switch (palCoefficient) {
            case PAL_1 -> ppm * 1.2;
            case PAL_2 -> ppm * 1.4;
            case PAL_3 -> ppm * 1.6;
            case PAL_4 -> ppm * 1.8;
            case PAL_5 -> ppm * 2.0;
        };

        DecimalFormat df = new DecimalFormat("#.##");
        String roundedNumberCPM = df.format(cpm);

        personDetailsEntity.setCpm(roundedNumberCPM);
        repository.save(personDetailsEntity);

        PersonDetails anthropometricIndicator = mapToPersonDetails(personDetailsEntity);
        anthropometricIndicator.setCpm(roundedNumberCPM);

        return anthropometricIndicator;
    }
    private String calculatePMMValue(double weight, double height, int age, String sex) {
        double ppm;
        if (sex.equals("Women")) {
            ppm = 655.1 + (9.563 * weight + (1.85 * height) - (4.676 * age));
        } else if (sex.equals("Men")) {
            ppm = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
        } else {
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
        } else if (bmi < 25) {
            return roundedNumberBMI + " " + "You are Normal: your BMI score is beetween 18,5 - 25,0";
        } else if (bmi < 30) {
            return roundedNumberBMI + " " + "You are  Overweight: your BMI score is beetween 25,0 - 30,0. You are outside the healthy BMI range (25 - 30)";
        } else {
            return roundedNumberBMI + " " + "You are  Obese: your BMI score is above 30,0. You are outside the healthy BMI range (25 - 30)";
        }
    }

    private PersonDetailsEntity mapToPersonDetailsEntity(CreatePersonDetails createPersonDetails) {
        PersonDetailsEntity personDetailsEntity = new PersonDetailsEntity();
        personDetailsEntity.setId(UUID.randomUUID());
        personDetailsEntity.setAge(createPersonDetails.getAge());
        personDetailsEntity.setWeight(createPersonDetails.getWeight());
        personDetailsEntity.setHeight(createPersonDetails.getHeight());
        personDetailsEntity.setSex(createPersonDetails.getSex());
        personDetailsEntity.setEnumPalCoefficient(createPersonDetails.getEnumPalCoefficient());
        return personDetailsEntity;
    }

    private PersonDetails mapToPersonDetails(PersonDetailsEntity personDetailsEntity) {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setId(personDetailsEntity.getId());
        personDetails.setAge(personDetailsEntity.getAge());
        personDetails.setWeight(personDetailsEntity.getWeight());
        personDetails.setHeight(personDetailsEntity.getHeight());
        personDetails.setSex(personDetailsEntity.getSex());
        personDetails.setEnumPalCoefficient(personDetailsEntity.getEnumPalCoefficient());
        personDetails.setBmi(personDetailsEntity.getBmi());
        personDetails.setPpm(personDetailsEntity.getPpm());
        personDetails.setCpm(personDetailsEntity.getCpm());
        return personDetails;
    }
}
