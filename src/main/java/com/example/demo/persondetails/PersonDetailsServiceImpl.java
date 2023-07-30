package com.example.demo.persondetails;

import com.example.demo.persondetails.DietInformation.DietInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class PersonDetailsServiceImpl implements PersonDetailsService {
    private final PersonDetailsRepository repository;


    @Override
    public PersonDetails createPersonDetails(CreatePersonDetails createPersonDetails) {
        PersonDetailsEntity personDetailsEntity = mapToPersonDetailsEntity(createPersonDetails);
        personDetailsEntity.setId(UUID.randomUUID());
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
        double heightInMeters = personDetailsEntity.getHeight() / 100.0;

        double bmi = personDetailsEntity.getWeight() / (heightInMeters * heightInMeters);

        BigDecimal bmiBigDecimal = BigDecimal.valueOf(bmi).setScale(2, RoundingMode.HALF_UP);
        double roundedNumberBMI = bmiBigDecimal.doubleValue();

        personDetailsEntity.setBmi(roundedNumberBMI);
        repository.save(personDetailsEntity);

        PersonDetails personDetails = mapToPersonDetails(personDetailsEntity);
        personDetails.setBmi(roundedNumberBMI);
        return personDetails;
    }

    @Override
    public PersonDetails calculatePPM(UUID id) {
        PersonDetailsEntity personDetailsEntity = repository.findById(id).get();

        double weight = personDetailsEntity.getWeight();
        double height = personDetailsEntity.getHeight();
        int age = personDetailsEntity.getAge();
        String sex = personDetailsEntity.getSex();

        double ppm = 0.0;

        if (sex.equals("Women")) {
            ppm = 655.1 + (9.563 * weight + (1.85 * height) - (4.676 * age));
        } else if (sex.equals("Man")) {
            ppm = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
        } else {
            throw new IllegalArgumentException("Incorrect sex, please check and try again");
        }

        BigDecimal ppmBigDecimal = BigDecimal.valueOf(ppm).setScale(2, RoundingMode.HALF_UP);
        double roundedNumberPPM = ppmBigDecimal.doubleValue();

        DietInformation dietInformation = new DietInformation();
        dietInformation.setPpm(roundedNumberPPM);
        personDetailsEntity.setDietinformation(dietInformation);

        repository.save(personDetailsEntity);

        PersonDetails personDetails = mapToPersonDetails(personDetailsEntity);
        personDetails.setPpm(roundedNumberPPM);
        return personDetails;
    }

    @Override
    public PersonDetails calculateCPM(UUID id) {
        PersonDetailsEntity personDetailsEntity = repository.findById(id).get();
        DietInformation dietInformation = repository.findById(id).get().getDietinformation();

        double ppm = dietInformation.getPpm();
        EnumPalCoefficient palCoefficient = personDetailsEntity.getEnumPalCoefficient();
        double cpm = switch (palCoefficient) {
            case PAL_1 -> ppm * 1.2;
            case PAL_2 -> ppm * 1.4;
            case PAL_3 -> ppm * 1.6;
            case PAL_4 -> ppm * 1.8;
            case PAL_5 -> ppm * 2.0;
        };

        BigDecimal bigDecimalCPM = BigDecimal.valueOf(cpm).setScale(2, RoundingMode.HALF_UP);
        double roundedNumberCPM = bigDecimalCPM.doubleValue();

        dietInformation.setCpm(roundedNumberCPM);
        personDetailsEntity.setDietinformation(dietInformation);
        repository.save(personDetailsEntity);

        PersonDetails personDetails = mapToPersonDetails(personDetailsEntity);
        personDetails.setCpm(roundedNumberCPM);

        return personDetails;
    }

    public ResponseEntity<List<Double>> calculateMacroelements(UUID id) {
        PersonDetailsEntity personDetailsEntity = repository.findById(id).get();
        DietInformation dietInformation = repository.findById(id).get().getDietinformation();
        Double cpmValue = dietInformation.getCpm();

        Double proteinKcal = (cpmValue / 100) * 10; //procentowy udział w diecie
        Double proteinPerGram = proteinKcal / 4; //4 kcal na gram białka

        BigDecimal bigDecimalProtein = BigDecimal.valueOf(proteinPerGram).setScale(2, RoundingMode.HALF_UP);
        double roundedProteinPerGram = bigDecimalProtein.doubleValue();

        dietInformation.setProtein(roundedProteinPerGram);
        personDetailsEntity.setDietinformation(dietInformation);

        Double fatKcal = (cpmValue / 100) * 30; //procentowy udział w diecie
        Double fatPerGram = fatKcal / 9; // 9 kcal na gram tłuszczu

        BigDecimal bigDecimalFat = BigDecimal.valueOf(fatPerGram).setScale(2, RoundingMode.HALF_UP);
        double roundedFatPerGram = bigDecimalFat.doubleValue();

        dietInformation.setFat(roundedFatPerGram);
        personDetailsEntity.setDietinformation(dietInformation);

        Double CarbsKcal = (cpmValue / 100) * 60; //procentowy udział w diecie
        Double CarbsPerGram = CarbsKcal / 4; //4 kcal na gram węglowodanów

        BigDecimal bigDecimalCarbs = BigDecimal.valueOf(CarbsPerGram).setScale(2, RoundingMode.HALF_UP);
        double roundedCarbsPerGram = bigDecimalCarbs.doubleValue();

        dietInformation.setCarbs(roundedCarbsPerGram);
        personDetailsEntity.setDietinformation(dietInformation);

        repository.save(personDetailsEntity);

        List<Double> macroelementsList = Arrays.asList(roundedProteinPerGram, roundedFatPerGram, roundedCarbsPerGram);
        return ResponseEntity.ok(macroelementsList);
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
        return personDetails;
    }
}
