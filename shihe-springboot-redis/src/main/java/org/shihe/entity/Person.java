package org.shihe.entity;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description TODO
 * @Author admin
 * @Date 2020-08-07 11:02
 * @Version 1.0
 */
public class Person implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;
    private String name;
    private Integer age;

    public Person(String id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
