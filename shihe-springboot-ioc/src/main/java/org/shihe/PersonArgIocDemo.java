package org.shihe;

import org.springframework.stereotype.Component;

/**
 * @ClassName PersonArgIocDemo
 * @Description TODO
 * @Author admin
 * @Date 2020-08-10 17:39
 * @Version 1.0
 */
public class PersonArgIocDemo {

    public Person person;

    public PersonArgIocDemo(Person person){
        this.person = person;
    }
}
