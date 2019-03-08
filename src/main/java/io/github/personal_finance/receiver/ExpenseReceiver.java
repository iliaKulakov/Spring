package io.github.personal_finance.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.domain.Expense;
import io.github.personal_finance.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ExpenseReceiver {

    private final ExpenseService expenseService;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public ExpenseReceiver(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public void receiveMessage(String message) throws IOException {
        ExpenceCreateInfo expenceCreateInfo = mapper.readValue(message, ExpenceCreateInfo.class);
        Expense expense = this.expenseService.createExpense(expenceCreateInfo);
    }
}
