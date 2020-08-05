package org.shihe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ShiheSpringbootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringbootSecurityApplication.class, args);
    }

}
