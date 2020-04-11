package io.jena.rabbitmqexample.service;

import io.jena.rabbitmqexample.RabbitmqExampleApplication;
import io.jena.rabbitmqexample.model.SimplifiedMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = RabbitmqExampleApplication.DEFAULT_PARSING_QUEUE)
    public void consumeMessage(final SimplifiedMessage message){


        System.out.println("Received message:"+message.getText());
    }
}
