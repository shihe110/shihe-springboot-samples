package com.shihe;

import com.shihe.mq.QueueProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jms.JMSException;

@SpringBootTest
class ShiheSpringbootMqProducerApplicationTests {
    @Autowired
    private QueueProducer queueProducer;
    @Test
    public void Test() throws JMSException {
        queueProducer.send();
    }
}
