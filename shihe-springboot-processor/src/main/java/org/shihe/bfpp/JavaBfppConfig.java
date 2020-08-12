package org.shihe.bfpp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName JavaConfig
 * @Description TODO
 * @Author admin
 * @Date 2020-08-12 12:33
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "org.shihe.bfpp")
public class JavaBfppConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomBeanService customBeanService){
        return args -> {
            customBeanService.doSomething();
        };
    }
}
