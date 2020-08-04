package org.shihe.controller;

import org.shihe.entity.Person;
import org.shihe.service.PersonServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CaheController
 * @Description TODO
 * @Author admin
 * @Date 2020-08-03 13:35
 * @Version 1.0
 */
@RestController
public class CaheController {

    @Autowired
    PersonServcie personServcie;

    @RequestMapping("/put")
    public Person put(Person person){
        return personServcie.save(person);
    }

    @RequestMapping("/able")
    public Person cacheable(Person person){
        return personServcie.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id){
        personServcie.remove(id);
        return "ok";
    }
}
