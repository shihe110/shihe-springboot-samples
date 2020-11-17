package com.shihe.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.jms.Topic;
import java.util.UUID;

/**
 * @ClassName QueueProducer
 * @Description TODO
 * @Author admin
 * @Date 2020-11-16 9:07
 * @Version 1.0
 */
@Component
public class QueueProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
   /* @Autowired
    private Queue queue;*/
    @Autowired
    private Topic topic;

    public void send() throws JMSException {

        jmsMessagingTemplate.convertAndSend(topic,"queue ***"+ UUID.randomUUID().toString().substring(0,10));
    }

    @Scheduled(fixedDelay = 3000L)
    public void scheduleSend(){
        jmsMessagingTemplate.convertAndSend(topic,"queue scheduled ***"+ UUID.randomUUID().toString().substring(0,10));
        System.out.println("scheduled send ok");
    }
}
