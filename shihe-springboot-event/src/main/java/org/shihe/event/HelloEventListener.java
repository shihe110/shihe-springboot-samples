package org.shihe.event;

import org.shihe.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName HelloEventListener
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 10:36
 * @Version 1.0
 */
@Component
public class HelloEventListener implements ApplicationListener<HelloEvent> {

    @Autowired
    private HelloService helloService;

    @Override
    public void onApplicationEvent(HelloEvent helloEvent) {
        String msg = helloEvent.getMsg();
        if (msg!=null){
            helloService.sayHello(msg);
        }
    }
}
