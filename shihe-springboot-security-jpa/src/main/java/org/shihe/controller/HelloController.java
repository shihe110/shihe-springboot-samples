package org.shihe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author admin
 * @Date 2020-08-20 12:25
 * @Version 1.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello springsecurity!!";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "admin hello springsecurity!!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "user hello springsecurity!!";
    }

}
