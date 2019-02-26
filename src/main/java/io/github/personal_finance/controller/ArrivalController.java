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

    private ExpenseRepository expenseRepository;
    private ArrivalRepository arrivalRepository;
    private CategoryRepository categoryRepository;
    private UsersRepository usersRepository;
    private ArrivalService arrivalService;

    @Autowired
    public ArrivalController(ExpenseRepository expenseRepository, ArrivalRepository arrivalRepository, CategoryRepository categoryRepository, UsersRepository usersRepository, ArrivalService arrivalService) {
        this.expenseRepository = expenseRepository;
        this.arrivalRepository = arrivalRepository;
        this.categoryRepository = categoryRepository;
        this.usersRepository = usersRepository;
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

        User user = this.usersRepository.findUserById(arrivalCreateInfo.getUserId());
        Category category = this.categoryRepository.findCategoryById(arrivalCreateInfo.getCategoryId());
        Arrival arrival = new Arrival(arrivalCreateInfo.getAmount(), user, category);

        arrival = this.arrivalRepository.save(arrival);
        return arrival;

//        User user = this.arrivalService.createArrivalService(arrivalCreateInfo);
//        return arrival;

    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void updateArrivalInformationInTable(@PathVariable(value = "id") Long id) {
//        this.arrivalRepository.deleteById(id);
        this.arrivalService.deleteArrivalInformationInTableService(id);
    }


    @ResponseBody
    @PutMapping(value = "/{id}")
    public Arrival updateArrivalInformationInTable(@PathVariable(value = "id") Long id, @RequestBody ArrivalUpdateInfo arrivalUpdateInfo) {
        Category category = this.categoryRepository.findCategoryById(arrivalUpdateInfo.getCategoryId());
        Arrival arrival = this.arrivalRepository.findArrivalByid(id);

        arrival.setCategory(category);
        arrival.setAmount(arrivalUpdateInfo.getAmount());
        arrival = this.arrivalRepository.save(arrival);
        return arrival;
    }


    @ResponseBody
    @GetMapping(value = "/{id}")
    public Arrival getArrivalById(@PathVariable(value = "id") Long id) {
        Arrival arrival = this.arrivalService.getArrivalByIdService(id);
        return arrival;
    }


}
