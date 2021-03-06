package io.github.personal_finance.service;

import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.controller.dto.ExpenceUpdateInfo;
import io.github.personal_finance.domain.Expense;

import java.util.List;

public interface ExpenseService {

    Expense createExpense(ExpenceCreateInfo expenceCreateInfo);

    List<Expense> getAllExpensesService();

    void deleteExpenseTableById(Long id);

    Expense updateExpenseTableById(Long id, ExpenceUpdateInfo expenceUpdateInfo);

    Expense getExpenseByIdService(Long id);


}
