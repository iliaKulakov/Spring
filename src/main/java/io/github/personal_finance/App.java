package io.github.personal_finance;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import io.github.personal_finance.receiver.ArrivalReceiver;
import io.github.personal_finance.receiver.ExpenseReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@SpringBootApplication(scanBasePackages = "io.github.personal_finance")
public class App {

    static final String topicExchangeName = "personal-finance";
    static final String queueName = "personal-finance";
    static final String topicExchangeNameArrival = "personal-finance-arrival";
    static final String queueNameArrival = "personal-finance-arrival";

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
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
    TopicExchange exchangeArrival() {
        return new TopicExchange(topicExchangeNameArrival);
    }


    @Bean
    Binding bindingArrival(Queue queueArrival, TopicExchange exchangeArrival) {
        return BindingBuilder.bind(queueArrival).to(exchangeArrival).with("foo.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer containerArrival(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
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


