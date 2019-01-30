package io.github.personal_finance.controller;

import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.controller.dto.ExpenceUpdateInfo;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.domain.Expense;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenseRepository;
import io.github.personal_finance.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;
    private UsersRepository usersRepository;

    @Autowired
    public ExpenseController(ExpenseRepository expenseRepository, CategoryRepository categoryRepository, UsersRepository usersRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
        this.usersRepository = usersRepository;
    }

    @ResponseBody
    @GetMapping
    public List<Expense> getAllExpenses() {
        List<Expense> categories = this.expenseRepository.findAll();

        return categories;
    }

    @ResponseBody
    @PostMapping
    public Expense createExpense(@RequestBody ExpenceCreateInfo expenceCreateInfo) {

        Category category = this.categoryRepository.findCategoryById(expenceCreateInfo.getCategoryId());
        User user = this.usersRepository.findUserById(expenceCreateInfo.getUserId());

        Expense expense = new Expense(category, user, expenceCreateInfo.getAmount());
        expense = this.expenseRepository.save(expense);
        return expense;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void updateExpenseTableById(@PathVariable(value = "id") Long id) {
        this.expenseRepository.deleteById(id);
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public Expense updateExpenseTableById(@PathVariable(value = "id") Long id, @RequestBody ExpenceUpdateInfo expenceUpdateInfo) {

        Category category = this.categoryRepository.findCategoryById(expenceUpdateInfo.getCategoryId());
        Expense expense = this.expenseRepository.findExpenceByid(id);

        expense.setCategory(category);
        expense.setAmount(expenceUpdateInfo.getAmount());

        expense = this.expenseRepository.save(expense);

        return expense;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Expense getExpenseById(@PathVariable(value = "id") Long id) {
        Expense expense = this.expenseRepository.findExpenceByid(id);

        return expense;
    }


}
