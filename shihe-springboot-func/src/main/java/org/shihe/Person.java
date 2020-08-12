package org.shihe;

/**
 * @ClassName Person
 * @Description TODO
 * @Author admin
 * @Date 2020-08-10 13:52
 * @Version 1.0
 */
public class Person {
    private String name; //名字
    private Gender gender; //性别
    private Integer weight = 0; //体重
    //无参构造
    public Person() {
        super();
    }
    //一个参数构造
    public Person(String name) {
        this.name = name;
    }
    //两个参数构造
    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
    //全参构造
    public Person(String name, Gender gender, Integer weight) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "名字是：" + name + "性别是：" + gender + "体重是：" + weight;
    }

    public boolean isMale(Person person){
        return person.getGender().equals(Gender.MALE);
    }
}
