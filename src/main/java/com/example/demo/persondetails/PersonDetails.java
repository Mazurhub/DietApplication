package com.example.demo.persondetails;

import com.example.demo.persondetails.WeightAndHeightMeasurements.HeightMeasurementsEntity;
import com.example.demo.persondetails.WeightAndHeightMeasurements.WeightMeasurementsEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"bmi", "ppm", "cpm", "protein", "fat", "carbs"})
public class PersonDetails {
    private UUID id;
    private List<WeightMeasurementsEntity> weightMeasurement = new ArrayList<>();
    private List<HeightMeasurementsEntity> heightMeasurement = new ArrayList<>();
    private Double weight;
    private Double height;
    private Integer age;
    private String sex;
    private double bmi;
    private double ppm;
    private double cpm;
    private double protein;
    private double fat;
    private double carbs;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private EnumPalCoefficient enumPalCoefficient;

    public Double getEnumPalCoefficient() {
        return enumPalCoefficient.getCoefficientAsString();
    }

    public void setWeightMeasurement(List<WeightMeasurementsEntity> weightMeasurement) {
        this.weightMeasurement = weightMeasurement;
    }

    public void setHeightMeasurement(List<HeightMeasurementsEntity> heightMeasurement) {
        this.heightMeasurement = heightMeasurement;
    }
}

