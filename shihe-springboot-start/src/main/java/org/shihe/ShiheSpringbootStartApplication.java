package org.shihe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ShiheSpringbootStartApplication {

    @GetMapping("/start")
    public String start(){
        return "hello spring boot!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringbootStartApplication.class, args);
    }

}
