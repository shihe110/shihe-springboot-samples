package org.shihe.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author admin
 * @Date 2020-08-24 15:01
 * @Version 1.0
 */
@Service
public class HelloService {

    private static int s = 0;

    private int ss = 0;

    public String hello(){
        s+=1;
        ss+=1;
        return s + "-" + ss;
    }

    public static int getS() {
        return s;
    }

    public static void setS(int s) {
        HelloService.s = s;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }
}
