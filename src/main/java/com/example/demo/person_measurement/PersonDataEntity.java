package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.PhysicalActivityLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
class PersonDataEntity {
    @Id
    private UUID personDataId;
    private Double weight;
    private Double height;
    private Integer age;
    private String sex;
    private PhysicalActivityLevel palCoefficient;

}
