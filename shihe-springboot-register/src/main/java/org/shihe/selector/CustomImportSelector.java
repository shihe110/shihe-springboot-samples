package org.shihe.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @ClassName CustomImportSelector
 * @Description TODO
 * @Author admin
 * @Date 2020-08-21 22:29
 * @Version 1.0
 */
public class CustomImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        System.out.println(annotationTypes.toString());

        return new String[]{"org.shihe.selector.selectorUser"};
    }
}
