package org.shihe.service;

import org.shihe.entity.Person;
import org.shihe.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @ClassName PersonServiceImpl
 * @Description TODO
 * @Author admin
 * @Date 2020-08-03 13:25
 * @Version 1.0
 */
@Service
public class PersonServiceImpl implements PersonServcie{

    @Autowired
    PersonRepository personRepository;

    @Override
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person save = personRepository.save(person);
        System.out.println("数据缓存 id key："+save.getId());
        return save;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
        Optional<Person> p = personRepository.findById(person.getId());
        return p.get();
    }
}
