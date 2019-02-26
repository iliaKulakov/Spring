package io.github.personal_finance.service;

import io.github.personal_finance.controller.dto.ArrivalCreateInfo;
import io.github.personal_finance.domain.Arrival;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ArrivalService {

    List<Arrival> getAllArrivalsService();

//    Arrival createArrivalService(ArrivalCreateInfo arrivalCreateInfo);
//
//    void updateArrivalInformationInTableService(Long id);
//
//    Arrival updateArrivalInformationInTableService();
//
    Arrival getArrivalByIdService(Long id);

}
