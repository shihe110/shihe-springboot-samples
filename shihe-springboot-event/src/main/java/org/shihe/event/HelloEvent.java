package org.shihe.event;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName HelloEvent
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 10:35
 * @Version 1.0
 */
public class HelloEvent extends ApplicationEvent {

    private String msg;

    public HelloEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
