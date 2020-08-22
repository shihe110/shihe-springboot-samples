package org.shihe;

import org.shihe.regsit.RegisUser;
import org.shihe.selector.CustomImportSelector;
import org.shihe.selector.SelectorUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ShiheSpringbootRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringbootRegisterApplication.class, args);
    }

    @Autowired
    SelectorUser selectorUser;

    @Autowired
    RegisUser regisUser;

    @GetMapping("/selector")
    public String hello(){
       return selectorUser.hello();
    }
    @GetMapping("/hello")
    public void hello1(){
         regisUser.hello();
    }
}
