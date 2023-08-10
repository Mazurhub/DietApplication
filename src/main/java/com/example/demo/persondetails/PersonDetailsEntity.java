package com.example.demo.persondetails;

import com.example.demo.person.PersonEntity;
import com.example.demo.persondetails.DietInformation.DietInformation;
import com.example.demo.persondetails.WeightAndHeightMeasurements.HeightMeasurementsEntity;
import com.example.demo.persondetails.WeightAndHeightMeasurements.WeightMeasurementRepository;
import com.example.demo.persondetails.WeightAndHeightMeasurements.WeightMeasurementsEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "persondetailsentity")
public class PersonDetailsEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    @OneToMany(mappedBy = "personDetailsEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeightMeasurementsEntity> weightMeasurement = new ArrayList<>();
    @OneToMany(mappedBy = "personDetailsEntity", cascade = CascadeType.ALL, orphanRemoval = true)
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dietinformation_id", referencedColumnName = "id")
    private DietInformation dietinformation;

    @OneToOne(mappedBy = "persondetailsentity")
    private PersonEntity personEntity;

    public void setWeightMeasurement(List<WeightMeasurementsEntity> weightMeasurement){
        this.weightMeasurement = weightMeasurement;
    }
    public void setHeightMeasurement(List<HeightMeasurementsEntity> heightMeasurement){
        this.heightMeasurement = heightMeasurement;
    }
    public void addHeightMeasurement(HeightMeasurementsEntity heightMeasurement) {
        this.heightMeasurement.add(heightMeasurement);
    }

    public void addWeightMeasurement(WeightMeasurementsEntity weightMeasurement) {
        this.weightMeasurement.add(weightMeasurement);
    }
    public List<HeightMeasurementsEntity> getHeightMeasurements() {
        return heightMeasurement;
    }

    public List<WeightMeasurementsEntity> getWeightMeasurements() {
        return weightMeasurement;
    }
}
