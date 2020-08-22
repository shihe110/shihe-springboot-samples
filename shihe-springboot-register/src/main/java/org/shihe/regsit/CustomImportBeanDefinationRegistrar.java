package org.shihe.regsit;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @ClassName CustomImportBeanDefinationRegistrar
 * @Description TODO
 * @Author admin
 * @Date 2020-08-21 22:42
 * @Version 1.0
 */
public class CustomImportBeanDefinationRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();

        boolean b = registry.containsBeanDefinition("org.shihe.regsit.RegisUser");
        if (b){
            RootBeanDefinition definition = new RootBeanDefinition(RegisUser.class);
            registry.registerBeanDefinition("RegisUser",definition);
        }
    }
}
