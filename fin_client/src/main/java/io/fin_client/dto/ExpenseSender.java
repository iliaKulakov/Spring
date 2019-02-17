package io.fin_client.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.fin_client.dto.dto.ExpenseCreateInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

public class ExpenseSender  {

    private Long inputCategoryId;
    private BigDecimal inputAmount;
    private Long userId;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ExpenseSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

}
