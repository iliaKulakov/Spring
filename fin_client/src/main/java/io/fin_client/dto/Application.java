package io.fin_client.dto;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Application {

    // Имя обменника
    static final String topicExchangeName = "personal-finance";
    // Имя очереди для отправки сообщения
    static final String queueName = "personal-finance";


    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args).close();

    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }


}
