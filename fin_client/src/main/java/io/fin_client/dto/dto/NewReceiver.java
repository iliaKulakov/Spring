package io.fin_client.dto.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import io.github.personal_finance.controller.dto.ExpenceCreateInfo;

import java.nio.charset.StandardCharsets;

public class NewReceiver {

    private static final String TASK_QUEUE_NAME = "personal-finance";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);


            String message = String.join(" ", argv);

           /* channel.basicPublish("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");*/

            channel.basicPublish("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");


           /* ObjectMapper mapper = new ObjectMapper();
            String message;
            ExpenceCreateInfo expenceCreateInfo = mapper.readValue(message, ExpenceCreateInfo.class);
            ExpenceCreateInfo expenceCreateInfo = mapper.readValue(message, ExpenceCreateInfo.class);*/


            // ExpenseCreateInfo expenseCreateInfo = new ExpenseCreateInfo(100L, BigDecimal.valueOf(100), 10);
           // System.out.println("test" + expenceCreateInfo.toString());

        }


    }
}
