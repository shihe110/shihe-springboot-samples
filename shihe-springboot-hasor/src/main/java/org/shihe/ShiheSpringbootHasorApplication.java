package org.shihe;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableHasorWeb
@EnableHasor
public class ShiheSpringbootHasorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringbootHasorApplication.class, args);
    }

}
