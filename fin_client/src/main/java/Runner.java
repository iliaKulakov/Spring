import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ExpenseCreateInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
// Создание мапера для вызова Jackson
        ObjectMapper mapper = new ObjectMapper();
// Инициализация DTO
        ExpenseCreateInfo expenseCreateInfo = new ExpenseCreateInfo(1L, BigDecimal.valueOf(100), 1L);
// Конвертация POJO в JSON представление
        String expenseJsonRepresentation = mapper.writeValueAsString(expenseCreateInfo);
// Отправка сообщения в очередь RabbitMQ
        rabbitTemplate.convertAndSend(Application.topicExchangeName, expenseJsonRepresentation);
    }

}
