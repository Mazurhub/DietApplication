package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.NewPersonDetail;
import org.springframework.stereotype.Component;

@Component
public class NewPersonDetailMapper {
    static NewPersonDetail mapToDTO(PersonDetailEntity personDetailEntity) {
        return new NewPersonDetail(
                personDetailEntity.getPersonDetailsHistory().getUserId(),
                personDetailEntity.getPersonDetailId(),
                personDetailEntity.getMeasurementDate(),
                personDetailEntity.getWeight(),
                personDetailEntity.getHeight(),
                personDetailEntity.getAge(),
                personDetailEntity.getSex(),
                personDetailEntity.getPalCoefficient().getPalCoefficient(),
                personDetailEntity.getBmi(),
                personDetailEntity.getPpm(),
                personDetailEntity.getCpm(),
                personDetailEntity.getProtein(),
                personDetailEntity.getFat(),
                personDetailEntity.getCarbs()
        );
    }
}
