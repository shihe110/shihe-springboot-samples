package org.shihe.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @ClassName Person
 * @Description TODO
 * @Author admin
 * @Date 2020-08-06 13:21
 * @Version 1.0
 */
@Document // 映射领域模型和mongodb的文档
public class Person {

    @Id // 该属性为文档的id
    private String id;
    private String name;
    private Integer age;

    @Field("locs") // 该属性在文档中的名称为locs，locations属性将以数组形式存在当前数据记录中。
    private Collection<Location> locations = new LinkedHashSet<Location>();

    public Person(String name, Integer age) {
        super();
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

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }
}
