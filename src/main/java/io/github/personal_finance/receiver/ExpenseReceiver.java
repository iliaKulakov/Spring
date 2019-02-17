package io.github.personal_finance.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.domain.Expense;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenseRepository;
import io.github.personal_finance.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ExpenseReceiver {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public ExpenseReceiver(ExpenseRepository expenseRepository, CategoryRepository categoryRepository, UsersRepository usersRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
        this.usersRepository = usersRepository;
    }

    public void receiveMessage(String message) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        ExpenceCreateInfo expenceCreateInfo = mapper.readValue(message, ExpenceCreateInfo.class);
        Category category = this.categoryRepository.findCategoryById(expenceCreateInfo.getCategoryId());
        User user = this.usersRepository.findUserById(expenceCreateInfo.getUserId());
        Expense expense = new Expense(category, user, expenceCreateInfo.getAmount());
        System.out.println("test" + expense);
        this.expenseRepository.save(expense);
    }
}
