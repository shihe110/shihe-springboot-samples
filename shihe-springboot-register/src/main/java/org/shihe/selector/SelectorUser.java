package org.shihe.selector;

/**
 * @ClassName SelectorUser
 * @Description TODO
 * @Author admin
 * @Date 2020-08-21 22:31
 * @Version 1.0
 */
public class SelectorUser {
    public String hello(){
        System.out.println("使用ImportSelector注册bean");
        return "使用ImportSelector注册bean";
    }
}
