package com.example.demo.persondetails.WeightAndHeightMeasurements;

import java.util.UUID;

public interface MeasurementService {
    HeightMeasurementsEntity addHeightMeasurement(UUID personId, Double heightValue);
    WeightMeasurementsEntity addWeightMeasurement(UUID personId, Double weightValue);
}
