package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.NewPersonDetail;
import org.springframework.stereotype.Component;

@Component
public class NewPersonDetailMapper {
    static NewPersonDetail mapToDTO(NewPersonDetailEntity newPersonDetailEntity) {
        return new NewPersonDetail(
                newPersonDetailEntity.getPersonDetailsHistory().getUserId(),
                newPersonDetailEntity.getPersonDetailId(),
                newPersonDetailEntity.getMeasurementDate(),
                newPersonDetailEntity.getWeight(),
                newPersonDetailEntity.getHeight(),
                newPersonDetailEntity.getAge(),
                newPersonDetailEntity.getSex(),
                newPersonDetailEntity.getPalCoefficient().getPalCoefficient(),
                newPersonDetailEntity.getBmi(),
                newPersonDetailEntity.getPpm(),
                newPersonDetailEntity.getCpm(),
                newPersonDetailEntity.getProtein(),
                newPersonDetailEntity.getFat(),
                newPersonDetailEntity.getCarbs()
        );
    }
}
