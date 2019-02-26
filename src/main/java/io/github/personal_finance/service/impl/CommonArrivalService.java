package io.github.personal_finance.service.impl;

import io.github.personal_finance.controller.dto.ArrivalCreateInfo;
import io.github.personal_finance.domain.Arrival;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repository.ArrivalRepository;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenseRepository;
import io.github.personal_finance.repository.UsersRepository;
import io.github.personal_finance.service.ArrivalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonArrivalService implements ArrivalService {

    private ArrivalRepository arrivalRepository;
    private CategoryRepository categoryRepository;
    private UsersRepository usersRepository;

    public CommonArrivalService(ArrivalRepository arrivalRepository, CategoryRepository categoryRepository, UsersRepository usersRepository) {
        this.arrivalRepository = arrivalRepository;
        this.categoryRepository = categoryRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Arrival> getAllArrivalsService() {
        List<Arrival> categories = this.arrivalRepository.findAll();
        return categories;
    }

//    @Override
//    public Arrival createArrivalService(ArrivalCreateInfo arrivalCreateInfo){
//
//    }

    public Arrival getArrivalByIdService(Long id){
        Arrival arrival = this.arrivalRepository.findArrivalByid(id);

        return arrival;
    }

}
