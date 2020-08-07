package org.shihe.repo;

import org.shihe.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @ClassName PersonRepository
 * @Description TODO
 * @Author admin
 * @Date 2020-08-06 13:28
 * @Version 1.0
 */
public interface PersonRepository extends MongoRepository<Person,String> {

    Person findByName(String name);

    @Query("{'age':?0}")
    List<Person> withQueryFindByAge(Integer age);
}
