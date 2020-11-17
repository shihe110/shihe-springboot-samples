package org.shihe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName ActiveMQConsumer
 * @Description TODO
 * @Author admin
 * @Date 2020-11-16 8:51
 * @Version 1.0
 */
@SpringBootApplication
public class ActiveMQConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActiveMQConsumerApplication.class,args);
    }
}
