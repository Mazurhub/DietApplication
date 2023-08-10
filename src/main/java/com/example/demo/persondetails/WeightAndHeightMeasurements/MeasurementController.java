package com.example.demo.persondetails.WeightAndHeightMeasurements;

import com.example.demo.persondetails.WeightAndHeightMeasurements.MeasurementService;
import com.example.demo.persondetails.WeightAndHeightMeasurements.HeightMeasurementsEntity;
import com.example.demo.persondetails.WeightAndHeightMeasurements.WeightMeasurementsEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MeasurementController {
    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("/addHeightMeasurement")
    public ResponseEntity<String> addHeightMeasurement(
            @RequestParam UUID personDetailsId,
            @RequestParam Double heightValue) {
        HeightMeasurementsEntity addedMeasurement = measurementService.addHeightMeasurement(personDetailsId, heightValue);
        return ResponseEntity.ok("Added new height measurement with ID: " + addedMeasurement.getId());
    }

    @PostMapping("/addWeightMeasurement")
    public ResponseEntity<String> addWeightMeasurement(
            @RequestParam UUID personDetailsId,
            @RequestParam Double weightValue) {
        WeightMeasurementsEntity addedMeasurement = measurementService.addWeightMeasurement(personDetailsId, weightValue);
        return ResponseEntity.ok("Added new weight measurement with ID: " + addedMeasurement.getId());
    }
}

