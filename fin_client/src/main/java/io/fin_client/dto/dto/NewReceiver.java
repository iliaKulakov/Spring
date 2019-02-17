package io.fin_client.dto.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import io.github.personal_finance.controller.dto.ExpenceCreateInfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class NewReceiver {

    private static final String TASK_QUEUE_NAME = "personal-finance";
    static final String topicExchangeName = "personal-finance";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueBind(TASK_QUEUE_NAME, topicExchangeName, "");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        //Как этот кусок работает
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };

        //channel.basicConsume(TASK_QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        //почему

        channel.basicConsume(TASK_QUEUE_NAME, true, deliverCallback, new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
            }
        });

    }

        }
