package io.github.personal_finance.service.impl;

import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.controller.dto.UserCreateDTO;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.domain.Expense;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenseRepository;
import io.github.personal_finance.repository.UsersRepository;
import io.github.personal_finance.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonExpenseService implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;
    private UsersRepository usersRepository;

    @Autowired
    public CommonExpenseService(ExpenseRepository expenseRepository, CategoryRepository categoryRepository, UsersRepository usersRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public Expense createExpense(ExpenceCreateInfo expenceCreateInfo) {
        Category category = this.categoryRepository.findCategoryById(expenceCreateInfo.getCategoryId());
        User user = this.usersRepository.findUserById(expenceCreateInfo.getUserId());

        Expense expense = new Expense(category, user, expenceCreateInfo.getAmount());
        expense = this.expenseRepository.save(expense);

        return expense;
    }


}
