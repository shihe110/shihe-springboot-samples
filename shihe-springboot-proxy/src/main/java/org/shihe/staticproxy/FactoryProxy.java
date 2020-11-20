package org.shihe.staticproxy;

/**
 * @ClassName FactoryProxy
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 13:35
 * @Version 1.0
 */
public class FactoryProxy implements Sell{

    Factory factory;

    public FactoryProxy(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void sellPhone() {
        System.out.println("代理售前打广告");
        factory.sellPhone();
        System.out.println("代理售后业务");
    }
}
