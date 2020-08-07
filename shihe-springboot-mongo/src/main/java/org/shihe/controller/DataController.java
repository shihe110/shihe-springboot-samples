package org.shihe.controller;

import org.shihe.entity.Location;
import org.shihe.entity.Person;
import org.shihe.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * @ClassName DataController
 * @Description TODO
 * @Author admin
 * @Date 2020-08-06 13:32
 * @Version 1.0
 */
@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(){
        Person shihe = new Person("shihe", 12);
        LinkedHashSet<Location> locations = new LinkedHashSet<>();
        locations.add(new Location("beijing","2020"));
        locations.add(new Location("shanghai","2020"));
        locations.add(new Location("shenzhen","2020"));

        shihe.setLocations(locations);

        return personRepository.save(shihe);

    }

    @RequestMapping("/f1")
    public Person findByName(String name){
        Person byName = personRepository.findByName(name);
        return byName;
    }

    @RequestMapping("/f2")
    public List<Person> findByQuery(Integer age){
        List<Person> s = personRepository.withQueryFindByAge(age);
        return s;
    }
}
