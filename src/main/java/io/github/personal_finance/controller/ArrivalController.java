package io.github.personal_finance.controller;

import io.github.personal_finance.controller.dto.ArrivalCreateInfo;
import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.domain.Arrival;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.domain.Expense;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repository.ArrivalRepository;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenseRepository;
import io.github.personal_finance.repository.UsersRepository;
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

        @Autowired
        public ArrivalController(ExpenseRepository expenseRepository, ArrivalRepository arrivalRepository, CategoryRepository categoryRepository, UsersRepository usersRepository) {
        this.expenseRepository = expenseRepository;
        this.arrivalRepository = arrivalRepository;
        this.categoryRepository = categoryRepository;
        this.usersRepository = usersRepository;
    }

    @ResponseBody
    @GetMapping
    public List<Arrival> getAllArrivals() {
        List<Arrival> categories = this.arrivalRepository.findAll();

        return categories;
    }

    @ResponseBody
    @PostMapping
    public Arrival createArrival(@RequestBody ArrivalCreateInfo arrivalCreateInfo){

            User user = this.usersRepository.findUserById(arrivalCreateInfo.getUserId());
            Category category = this.categoryRepository.findCategoryById(arrivalCreateInfo.getCategoryId());
            Arrival arrival = new Arrival(arrivalCreateInfo.getAmount(),user,category);

            arrival = this.arrivalRepository.save(arrival);
            return arrival;

    }




}
