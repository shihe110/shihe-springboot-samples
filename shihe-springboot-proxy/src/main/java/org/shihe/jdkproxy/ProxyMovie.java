package org.shihe.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName ProxyMovie
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 13:50
 * @Version 1.0
 */
public class ProxyMovie implements InvocationHandler {

    private Object o;

    public ProxyMovie(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置处理");
        method.invoke(o,args);
        System.out.println("后置处理");
        return null;
    }
}
