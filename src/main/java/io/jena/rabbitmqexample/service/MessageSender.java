package io.jena.rabbitmqexample.service;

import io.jena.rabbitmqexample.RabbitmqExampleApplication;
import io.jena.rabbitmqexample.model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 30000L)
    public void sendMessage(){

        Message message = new Message("always use immutable in java",1,false);
        rabbitTemplate.convertAndSend(RabbitmqExampleApplication.EXCHANGE_NAME,RabbitmqExampleApplication.ROUTING_KEY,message);

        System.out.println("message sent");
    }


}
