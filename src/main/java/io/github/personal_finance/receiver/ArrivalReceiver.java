package io.github.personal_finance.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.personal_finance.controller.dto.ArrivalCreateInfo;
import io.github.personal_finance.controller.dto.ExpenceCreateInfo;
import io.github.personal_finance.domain.Arrival;
import io.github.personal_finance.domain.Category;
import io.github.personal_finance.domain.Expense;
import io.github.personal_finance.domain.User;
import io.github.personal_finance.repository.ArrivalRepository;
import io.github.personal_finance.repository.CategoryRepository;
import io.github.personal_finance.repository.ExpenseRepository;
import io.github.personal_finance.repository.UsersRepository;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "personal-finance-arrival")
public class ArrivalReceiver {

    private final ArrivalRepository arrivalRepository;
    private final CategoryRepository categoryRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public ArrivalReceiver(ArrivalRepository arrivalRepository, CategoryRepository categoryRepository, UsersRepository usersRepository) {
        this.arrivalRepository = arrivalRepository;
        this.categoryRepository = categoryRepository;
        this.usersRepository = usersRepository;
    }

    @RabbitHandler
    public void receiveMessageArrival(String message) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        ArrivalCreateInfo arrivalCreateInfo = mapper.readValue(message, ArrivalCreateInfo.class);
        Category category = this.categoryRepository.findCategoryById(arrivalCreateInfo.getCategoryId());
        User user = this.usersRepository.findUserById(arrivalCreateInfo.getUserId());
        Arrival arrival= new Arrival( arrivalCreateInfo.getAmount(), user, category);
        System.out.println("test" + arrival);
        this.arrivalRepository.save(arrival);
    }
}


