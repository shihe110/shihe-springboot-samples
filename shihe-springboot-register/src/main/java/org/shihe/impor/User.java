package org.shihe.impor;

/**
 * @ClassName User
 * @Description TODO
 * @Author admin
 * @Date 2020-08-21 22:22
 * @Version 1.0
 */
public class User {

    String username;
    String password;

    public void hello(){
        System.out.println("import注册bean");
    }
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
