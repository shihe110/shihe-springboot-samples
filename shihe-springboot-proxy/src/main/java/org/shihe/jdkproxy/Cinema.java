package org.shihe.jdkproxy;

/**
 * @ClassName Cinema
 * @Description TODO
 * @Author admin
 * @Date 2020-08-25 13:49
 * @Version 1.0
 */
public class Cinema implements Movie{
    @Override
    public void play() {
        System.out.println("电影院正在放电影");
    }
}
