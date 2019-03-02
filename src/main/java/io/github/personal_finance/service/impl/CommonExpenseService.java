package io.github.personal_finance.service.impl;

import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.controller.dto.ExpenceUpdateInfo;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.domain.Expense;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenseRepository;
import io.github.personal_finance.repository.UsersRepository;
import io.github.personal_finance.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Expense> getAllExpensesService() {
        List<Expense> categories = this.expenseRepository.findAll();

        return categories;
    }

    @Override
    public Expense getExpenseByIdService(Long id) {
        Expense expense = this.expenseRepository.findExpenceByid(id);
        return expense;
    }

    @Override
    public void deleteExpenseTableById(Long id) {
        this.expenseRepository.deleteById(id);
    }

    @Override
    public Expense updateExpenseTableById(Long id, ExpenceUpdateInfo expenceUpdateInfo) {
        Category category = this.categoryRepository.findCategoryById(expenceUpdateInfo.getCategoryId());
        Expense expense = this.expenseRepository.findExpenceByid(id);

        expense.setCategory(category);
        expense.setAmount(expenceUpdateInfo.getAmount());

        expense = this.expenseRepository.save(expense);

        return expense;
    }

}
