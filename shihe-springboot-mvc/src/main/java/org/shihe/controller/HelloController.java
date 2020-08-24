package org.shihe.controller;

import org.shihe.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author admin
 * @Date 2020-08-24 15:01
 * @Version 1.0
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;


    @GetMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        String hello = helloService.hello();
        response.addHeader("hello",hello);
        System.out.println(hello);
        return hello;
    }


}
