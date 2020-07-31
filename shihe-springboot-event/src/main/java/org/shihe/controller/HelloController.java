package org.shihe.controller;

import org.shihe.event.HelloEventPublisher;
import org.shihe.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 10:39
 * @Version 1.0
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private HelloEventPublisher helloEventPublisher;

    @GetMapping("/hello")
    public String sayHello(String name){
        helloEventPublisher.publish(name + " 调用helloService了！");
        return helloService.sayHello(name);
    }
}
