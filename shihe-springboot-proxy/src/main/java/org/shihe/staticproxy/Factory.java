package org.shihe.staticproxy;

/**
 * @ClassName Factory
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 13:34
 * @Version 1.0
 */
public class Factory implements Sell{
    @Override
    public void sellPhone() {
        System.out.println("Factory sell phone");
    }
}
