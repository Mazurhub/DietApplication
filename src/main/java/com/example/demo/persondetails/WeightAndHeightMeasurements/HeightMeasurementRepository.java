package com.example.demo.persondetails.WeightAndHeightMeasurements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeightMeasurementRepository extends JpaRepository<HeightMeasurementsEntity, Long> {

}
