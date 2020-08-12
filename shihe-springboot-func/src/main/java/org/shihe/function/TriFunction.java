package org.shihe.function;

/**
 * @ClassName TriFunction
 * @Description TODO
 * @Author admin
 * @Date 2020-08-10 15:33
 * @Version 1.0
 */
@FunctionalInterface
public interface TriFunction<T,U,W,R> {
    R apply(T t,U u,W w);
}
