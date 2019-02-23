package io.github.personal_finance.service;

import io.github.personal_finance.controller.dto.ArrivalCreateInfo;
import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.domain.Arrival;
import io.github.personal_finance.domain.Expense;
import io.github.personal_finance.domain.User;

public interface ExpenseService {

    Expense createExpense(ExpenceCreateInfo expenceCreateInfo);

    Arrival createArrival(ArrivalCreateInfo arrivalCreateInfo);
}
