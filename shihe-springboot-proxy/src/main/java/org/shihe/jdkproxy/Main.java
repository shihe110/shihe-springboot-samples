package org.shihe.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 13:55
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        InvocationHandler proxyMovie = new ProxyMovie(cinema);
        Movie o = (Movie) Proxy.newProxyInstance(Cinema.class.getClassLoader(), Cinema.class.getInterfaces(), proxyMovie);
        o.play();
    }
}
