package org.shihe.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 10:38
 * @Version 1.0
 */
@Service
public class HelloService {

    public String sayHello(String name){
        System.out.println("================="+name);
        return name + " say Hello!!";
    }
}
