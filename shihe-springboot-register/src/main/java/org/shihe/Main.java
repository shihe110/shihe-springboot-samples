package org.shihe;

import org.shihe.config.ImportConfig;
import org.shihe.impor.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-08-21 22:24
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        // @Import导入bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportConfig.class);
        User user = context.getBean(User.class);
        user.hello();

    }
}
