package io.github.personal_finance.controller;

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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @ResponseBody
    @GetMapping
    public List<Expense> getAllExpenses() {

        List<Expense> categories = this.expenseService.getAllExpensesService();

        return categories;
    }

    @ResponseBody
    @PostMapping
    public Expense createExpense(@RequestBody ExpenceCreateInfo expenceCreateInfo) {

        Expense expense = this.expenseService.createExpense(expenceCreateInfo);
        return expense;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void updateExpenseTableById(@PathVariable(value = "id") Long id) {

        this.expenseService.deleteExpenseTableById(id);
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public Expense updateExpenseTableById(@PathVariable(value = "id") Long id, @RequestBody ExpenceUpdateInfo expenceUpdateInfo) {

        Expense expense = this.expenseService.updateExpenseTableById(id,expenceUpdateInfo);
        return expense;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Expense getExpenseById(@PathVariable(value = "id") Long id) {

        Expense expense = this.expenseService.getExpenseByIdService(id);
        return expense;
    }


}
