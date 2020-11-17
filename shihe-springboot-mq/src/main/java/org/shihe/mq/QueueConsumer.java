package org.shihe.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @ClassName QueueConsumer
 * @Description TODO
 * @Author admin
 * @Date 2020-11-16 8:58
 * @Version 1.0
 */
@Component
public class QueueConsumer {

    @JmsListener(destination = "${mytopic}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("********topic消息消费****"+textMessage.getText());
    }

}
