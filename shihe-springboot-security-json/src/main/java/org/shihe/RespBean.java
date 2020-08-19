package org.shihe;

/**
 * @ClassName RespBean
 * @Description TODO
 * @Author admin
 * @Date 2020-08-18 17:35
 * @Version 1.0
 */
public class RespBean {
    private String error;

    private String msg;

    public RespBean() {
    }

    public RespBean(String error, String msg) {
        this.error = error;
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
