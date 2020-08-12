package org.shihe;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-08-10 17:31
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
        Person person = (Person) context.getBean("getPerson");
        System.out.println(person.toString());

        PersonArgIocDemo bean = context.getBean(PersonArgIocDemo.class);

        System.out.println(bean.person.toString());
    }
}
