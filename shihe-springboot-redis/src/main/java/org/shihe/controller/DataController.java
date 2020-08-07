package org.shihe.controller;

import org.shihe.dao.PersonDao;
import org.shihe.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DataController
 * @Description TODO
 * @Author admin
 * @Date 2020-08-07 11:21
 * @Version 1.0
 */
@RestController
public class DataController {

    @Autowired
    PersonDao personDao;

    @RequestMapping("/set")
    public void set(){
        Person person = new Person("1", "zhangsan", 12);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    @RequestMapping("/getStr")
    public String getStr(){
        return personDao.getString();
    }

    @RequestMapping("/getPerson")
    public Person getPerson(){
        return personDao.getPerson();
    }
}
