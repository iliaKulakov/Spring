package io.fin_client.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.fin_client.dto.dto.ExpenseCreateInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    Long inputId;

    @Autowired
    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
// Создание мапера для вызова Jackson
        ObjectMapper mapper = new ObjectMapper();
// Инициализация DTO
      KeyBoardInput keyBoardInput = new KeyBoardInput();
      inputId = keyBoardInput.enterFromKeyBoard();

      //  ExpenseCreateInfo expenseCreateInfo = new ExpenseCreateInfo(1L, BigDecimal.valueOf(100), 1L);
        ExpenseCreateInfo expenseCreateInfo = new ExpenseCreateInfo(inputId, BigDecimal.valueOf(100), inputId);
// Конвертация POJO в JSON представление
        String expenseJsonRepresentation = mapper.writeValueAsString(expenseCreateInfo);
// Отправка сообщения в очередь RabbitMQ
        rabbitTemplate.convertAndSend(Application.topicExchangeName, expenseJsonRepresentation);
    }

}
