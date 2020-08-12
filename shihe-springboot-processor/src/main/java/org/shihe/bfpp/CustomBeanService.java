package org.shihe.bfpp;

/**
 * @ClassName CustomBeanService
 * @Description TODO
 * @Author admin
 * @Date 2020-08-12 12:29
 * @Version 1.0
 */
@CustomBean
public class CustomBeanService {

    public void doSomething(){
        System.out.println("自定义注解注入bean成功");
    }
}
