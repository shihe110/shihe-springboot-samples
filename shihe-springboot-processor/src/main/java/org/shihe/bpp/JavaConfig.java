package org.shihe.bpp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName JavaConfig
 * @Description TODO
 * @Author admin
 * @Date 2020-08-12 11:35
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "org.shihe.bpp")
public class JavaConfig {

    @Bean
    CommandLineRunner changeAnnotationBeanPostProcessorClr(DemoLoggerService demoLoggerService){
        return args -> {
            demoLoggerService.dosomeThing();
        };
    }
}
