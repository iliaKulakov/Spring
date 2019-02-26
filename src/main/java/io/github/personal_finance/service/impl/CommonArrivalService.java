package io.github.personal_finance.service.impl;

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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Override
    public Arrival createArrivalInfoService(ArrivalCreateInfo arrivalCreateInfo){

        User user = this.usersRepository.findUserById(arrivalCreateInfo.getUserId());
        Category category = this.categoryRepository.findCategoryById(arrivalCreateInfo.getCategoryId());
        Arrival arrival = new Arrival(arrivalCreateInfo.getAmount(), user, category);

        arrival = this.arrivalRepository.save(arrival);
        return arrival;
    }

    @Override
    public Arrival getArrivalByIdService(Long id){
        Arrival arrival = this.arrivalRepository.findArrivalByid(id);

        return arrival;
    }

    @Override
    public void deleteArrivalInformationInTableService(Long id){
        this.arrivalRepository.deleteById(id);
    }

    @Override
     public Arrival updateArrivalInformationInTableService( Long id, ArrivalUpdateInfo arrivalUpdateInfo){
         Category category = this.categoryRepository.findCategoryById(arrivalUpdateInfo.getCategoryId());
         Arrival arrival = this.arrivalRepository.findArrivalByid(id);

         arrival.setCategory(category);
         arrival.setAmount(arrivalUpdateInfo.getAmount());
         arrival = this.arrivalRepository.save(arrival);
         return arrival;
     }

}
