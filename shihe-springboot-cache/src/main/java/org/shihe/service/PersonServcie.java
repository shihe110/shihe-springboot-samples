package org.shihe.service;

import org.shihe.entity.Person;

/**
 * @ClassName PersonServcie
 * @Description TODO
 * @Author admin
 * @Date 2020-08-03 13:24
 * @Version 1.0
 */
public interface PersonServcie {

    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Person person);

}
