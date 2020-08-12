package org.shihe.bpp;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @ClassName DemoLoggerService
 * @Description TODO
 * @Author admin
 * @Date 2020-08-12 11:34
 * @Version 1.0
 */
@Component
public class DemoLoggerService {

    @InjectLogger
    private Logger log;

    public void dosomeThing(){
        log.info("通过自定义InjectLoggerAnnotationBeanPostPorcessor让注解@InjectLogger注入Logger对象");
    }
}
