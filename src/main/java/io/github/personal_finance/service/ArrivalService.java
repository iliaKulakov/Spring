package io.github.personal_finance.service;

import io.github.personal_finance.controller.dto.ArrivalCreateInfo;
import io.github.personal_finance.controller.dto.ArrivalUpdateInfo;
import io.github.personal_finance.domain.Arrival;

import java.util.List;

public interface ArrivalService {

    List<Arrival> getAllArrivalsService();

    Arrival createArrivalInfoService(ArrivalCreateInfo arrivalCreateInfo);

    void deleteArrivalInformationInTableService(Long id);

    Arrival updateArrivalInformationInTableService(Long id, ArrivalUpdateInfo arrivalUpdateInfo);

    Arrival getArrivalByIdService(Long id);

}
