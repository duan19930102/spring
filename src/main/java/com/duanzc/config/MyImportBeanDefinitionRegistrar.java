/**
 * FileName: MyImportBean
 * Author:   Administrator
 * Date:     2019/7/31 15:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.duanzc.config;

import com.duanzc.domain.Read;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/31
 * @since 1.0.0
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param annotationMetadata  类的注解信息
     * @param beanDefinitionRegistry BeanDefinition的注册类
     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
       Boolean booleanBlue = beanDefinitionRegistry.containsBeanDefinition("com.duanzc.domain.Blue");
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Read.class);
       if(booleanBlue){
           beanDefinitionRegistry.registerBeanDefinition("read",rootBeanDefinition);
       }


    }
}