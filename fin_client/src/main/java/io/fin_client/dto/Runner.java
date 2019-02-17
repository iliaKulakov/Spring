package io.fin_client.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fin_client.dto.dto.ArrivalCreateInfo;
import io.fin_client.dto.dto.ExpenseCreateInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    int ExpenseVariableForChoose = 1;
    Long inputCategoryId;
    BigDecimal inputAmount;
    Long userId;

    @Autowired
    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
// Создание мапера для вызова Jackson
        ObjectMapper mapper = new ObjectMapper();
// Инициализация DTO
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number 1 - Expense  2 - Arrival: ");
        int chooseVariable = in.nextInt();
        if (chooseVariable == ExpenseVariableForChoose) {
            sendExpenseMessage();
        } else {
            sendArrivalMessage();
        }
    }

    public void sendExpenseMessage() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        KeyBoardInput keyBoardInput = new KeyBoardInput();

        inputCategoryId = keyBoardInput.enterCategoryIdFromKeyBoard();
        inputAmount = keyBoardInput.enterAmountFromKeyBoard();
        userId = keyBoardInput.enterUserIdFromKeyBoard();

        //ExpenseCreateInfo expenseCreateInfo = new ExpenseCreateInfo(100L,BigDecimal.valueOf(100), 10);
        ExpenseCreateInfo expenseCreateInfo = new ExpenseCreateInfo(inputCategoryId, inputAmount, userId);
        // Конвертация POJO в JSON представление
        String expenseJsonRepresentation = mapper.writeValueAsString(expenseCreateInfo);
        // Отправка сообщения в очередь RabbitMQ
        rabbitTemplate.convertAndSend(Application.topicExchangeName, expenseJsonRepresentation);

    }

    public void sendArrivalMessage() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        KeyBoardInput keyBoardInput = new KeyBoardInput();

        inputCategoryId = keyBoardInput.enterCategoryIdFromKeyBoard();
        inputAmount = keyBoardInput.enterAmountFromKeyBoard();
        userId = keyBoardInput.enterUserIdFromKeyBoard();

        ArrivalCreateInfo arrivalCreateInfo = new ArrivalCreateInfo(inputCategoryId, inputAmount, userId);
        String arrivalJsonRepresentation = mapper.writeValueAsString(arrivalCreateInfo);
        rabbitTemplate.convertAndSend(Application.topicExchangeNameArrival, arrivalJsonRepresentation);
    }

}
