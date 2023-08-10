package com.example.demo.persondetails;

import com.example.demo.persondetails.WeightAndHeightMeasurements.HeightMeasurementsEntity;
import com.example.demo.persondetails.WeightAndHeightMeasurements.WeightMeasurementsEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreatePersonDetails {
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
    private EnumPalCoefficient enumPalCoefficient;
}
