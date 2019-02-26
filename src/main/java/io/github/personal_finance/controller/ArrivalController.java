package io.github.personal_finance.controller;

import io.github.personal_finance.controller.dto.ArrivalCreateInfo;
import io.github.personal_finance.controller.dto.ArrivalUpdateInfo;
import io.github.personal_finance.domain.Arrival;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repository.ArrivalRepository;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenseRepository;
import io.github.personal_finance.repository.UsersRepository;
import io.github.personal_finance.service.ArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arrival")
public class ArrivalController {

    private ArrivalService arrivalService;

    @Autowired
    public ArrivalController(ArrivalService arrivalService) {
        this.arrivalService = arrivalService;
    }

    @ResponseBody
    @GetMapping
    public List<Arrival> getAllArrivals() {
        List<Arrival> categories = this.arrivalService.getAllArrivalsService();
        return categories;
    }

    @ResponseBody
    @PostMapping
    public Arrival createArrival(@RequestBody ArrivalCreateInfo arrivalCreateInfo) {
        Arrival arrival = this.arrivalService.createArrivalInfoService(arrivalCreateInfo);
        return arrival;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void updateArrivalInformationInTable(@PathVariable(value = "id") Long id) {
        this.arrivalService.deleteArrivalInformationInTableService(id);
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public Arrival updateArrivalInformationInTable(@PathVariable(value = "id") Long id, @RequestBody ArrivalUpdateInfo arrivalUpdateInfo) {
        Arrival arrival = this.arrivalService.updateArrivalInformationInTableService(id,arrivalUpdateInfo);
        return arrival;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Arrival getArrivalById(@PathVariable(value = "id") Long id) {
        Arrival arrival = this.arrivalService.getArrivalByIdService(id);
        return arrival;
    }


}
