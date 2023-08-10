package com.example.demo.persondetails.WeightAndHeightMeasurements;

import com.example.demo.persondetails.PersonDetailsEntity;
import com.example.demo.persondetails.PersonDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {
    private final WeightMeasurementRepository weightMeasurementRepository;
    private final HeightMeasurementRepository heightMeasurementRepository;
    private final PersonDetailsRepository personDetailsRepository;

    @Override
    public HeightMeasurementsEntity addHeightMeasurement(UUID personDetailsId, Double heightValue) {
        PersonDetailsEntity personDetails = personDetailsRepository.findById(personDetailsId).get();
        LocalDateTime measurementDate = LocalDateTime.now();
        HeightMeasurementsEntity newHeightMeasurement = new HeightMeasurementsEntity(heightValue, measurementDate, personDetails);
        personDetails.addHeightMeasurement(newHeightMeasurement);
        personDetailsRepository.save(personDetails); // Zapisz zaktualizowaną osobę w bazie
        return null;
    }

    @Override
    public WeightMeasurementsEntity addWeightMeasurement(UUID personDetailsId, Double weightValue) {
        PersonDetailsEntity personDetails = personDetailsRepository.findById(personDetailsId).get();
        LocalDateTime measurementDate = LocalDateTime.now();
        WeightMeasurementsEntity newWeightMeasurement = new WeightMeasurementsEntity(weightValue, measurementDate, personDetails);

        personDetails.getWeightMeasurements().add(newWeightMeasurement);
        personDetailsRepository.save(personDetails);

        return weightMeasurementRepository.save(newWeightMeasurement);
    }
}
