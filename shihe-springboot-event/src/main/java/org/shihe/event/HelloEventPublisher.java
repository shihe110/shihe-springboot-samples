package org.shihe.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName HelloEventPublisher
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 10:43
 * @Version 1.0
 */
@Component
public class HelloEventPublisher {

    @Autowired
    private ApplicationContext context;

    public void publish(String msg){
        context.publishEvent(new HelloEvent(this,msg));
    }
}
