package com.shihe.h2.controller;

import com.shihe.h2.dao.UserRepository;
import com.shihe.h2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/hello")
    public List<User> hello(int id){
        User user = new User();
        user.setUserId(id);;
        user.setUserName("zhangsan"+id);

        repository.save(user);

        List<User> all = repository.findAll();
        return all;
    }

    @RequestMapping("/rest")
    public String rest(){
        return "hello ";
    }


}
