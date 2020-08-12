package org.shihe;

import jdk.nashorn.internal.ir.CallNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamDemo
 * @Description TODO
 * @Author admin
 * @Date 2020-08-10 15:51
 * @Version 1.0
 */
public class StreamDemo {

    // 什么是stream

    // 如何获取stream

    // 操作stream

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("wyf",Gender.MALE, 100),
                new Person("www", Gender.FEMALE, 80),
                new Person("foo", Gender.FEMALE, 90),
                new Person("foo", Gender.FEMALE, 90));
        Stream<Person> stream = personList.stream();

        // filter
        stream.filter(person -> person.getGender().equals(Gender.MALE))
        .forEach(person -> System.out.println(person.getName()));

        stream.filter(Person::isMale).forEach(System.out::println);



    }
}
