package org.shihe.bpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;

/**
 * @ClassName InjectLoggerAnnotationBeanPostProcessor
 * @Description TODO
 * @Author admin
 * @Date 2020-08-12 11:30
 * @Version 1.0
 */
@Component
public class InjectLoggerAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Class<? extends Annotation> annotationType;

    public InjectLoggerAnnotationBeanPostProcessor() {
        this.annotationType = InjectLogger.class;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(),field -> {
            ReflectionUtils.makeAccessible(field);
            if (field.isAnnotationPresent(annotationType)){
                Logger log = LoggerFactory.getLogger(bean.getClass());
                field.set(bean,log);
            }
        });
        return bean;
    }
}
