package com.example.demo.persondetails.WeightAndHeightMeasurements;

import com.example.demo.persondetails.PersonDetailsEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "WeightMeasurementsEntity")
public class WeightMeasurementsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double weightValue;
    private LocalDateTime weightMeasurementDate;
    @ManyToOne
    @JoinColumn(name = "personDetailsEntity_id")
    private PersonDetailsEntity personDetailsEntity;

    public WeightMeasurementsEntity() {
    }

    public WeightMeasurementsEntity(Double weightValue, LocalDateTime weightMeasurementDate, PersonDetailsEntity personDetailsEntity) {
        this.weightValue = weightValue;
        this.weightMeasurementDate = weightMeasurementDate;
        this.personDetailsEntity = personDetailsEntity;
    }
}
