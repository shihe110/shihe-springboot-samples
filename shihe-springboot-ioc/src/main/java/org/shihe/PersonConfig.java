package org.shihe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName PersonConfig
 * @Description TODO
 * @Author admin
 * @Date 2020-08-10 17:29
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "org.shihe")
public class PersonConfig {

    @Bean
    Person getPerson(){
        return new Person("zhangsan",20);
    }

    @Bean
    PersonArgIocDemo personArgIocDemo(Person person){
        return new PersonArgIocDemo(person);
    }
}
