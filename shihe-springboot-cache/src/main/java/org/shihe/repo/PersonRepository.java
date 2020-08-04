package org.shihe.repo;

import org.shihe.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName PersonRepository
 * @Description TODO
 * @Author admin
 * @Date 2020-08-03 13:22
 * @Version 1.0
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
