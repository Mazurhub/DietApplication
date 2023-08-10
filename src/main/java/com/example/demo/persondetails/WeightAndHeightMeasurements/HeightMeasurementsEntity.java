package com.example.demo.persondetails.WeightAndHeightMeasurements;

import com.example.demo.persondetails.PersonDetailsEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "HeightMeasurementsEntity")
public class HeightMeasurementsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double heightValue;
    private LocalDateTime heightMeasurementDate;
    @ManyToOne
    @JoinColumn(name = "personDetailsEntity_id")
    private PersonDetailsEntity personDetailsEntity;

    public HeightMeasurementsEntity() {
    }

    public HeightMeasurementsEntity(Double heightValue, LocalDateTime heightMeasurementDate, PersonDetailsEntity personDetailsEntity) {
        this.heightValue = heightValue;
        this.heightMeasurementDate = heightMeasurementDate;
        this.personDetailsEntity = personDetailsEntity;
    }
}
