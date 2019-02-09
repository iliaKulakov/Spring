package io.github.personal_finance.controller;

import io.github.personal_finance.domain.Arrival;
import io.github.personal_finance.domain.Expense;
import io.github.personal_finance.repository.ArrivalRepository;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenseRepository;
import io.github.personal_finance.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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




}
