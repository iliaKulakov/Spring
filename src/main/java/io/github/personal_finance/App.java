package io.github.personal_finance;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import io.github.personal_finance.receiver.ArrivalReceiver;
import io.github.personal_finance.receiver.ExpenseReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@SpringBootApplication(scanBasePackages = "io.github.personal_finance")
public class App {

    static final String queueName = "personal-finance";
    static final String queueNameArrival = "personal-finance-arrival";

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             @Qualifier("listenerAdapter") MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(ExpenseReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }


    @Bean
    Queue queueArrival() {
        return new Queue(queueNameArrival, false);
    }

    @Bean
    SimpleMessageListenerContainer containerArrival(ConnectionFactory connectionFactory,
                                                    @Qualifier("listenerAdapterArrival") MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueNameArrival);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapterArrival(ArrivalReceiver arrivalReceiver) {
        return new MessageListenerAdapter(arrivalReceiver, "receiveMessageArrival");
    }


}


