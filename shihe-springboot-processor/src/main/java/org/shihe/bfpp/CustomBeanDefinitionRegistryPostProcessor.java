package org.shihe.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

/**
 * @ClassName CustomBeanDefinitionRegistryPostProcessor
 * @Description TODO
 * @Author admin
 * @Date 2020-08-12 12:30
 * @Version 1.0
 */
@Component
public class CustomBeanDefinitionRegistryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner((BeanDefinitionRegistry) beanFactory);
        scanner.addIncludeFilter(new AnnotationTypeFilter(CustomBean.class));
        scanner.scan("org.shihe.bfpp");
    }
}
