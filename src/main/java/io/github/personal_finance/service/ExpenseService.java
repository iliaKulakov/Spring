package io.github.personal_finance.service;

import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.domain.Expense;

public interface ExpenseService {

    Expense createExpense(ExpenceCreateInfo expenceCreateInfo);
}
