package org.shihe.staticproxy;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 13:38
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        FactoryProxy factoryProxy = new FactoryProxy(new Factory());
        factoryProxy.sellPhone();
    }
}
