/**
 * FileName: LinuxCondition
 * Author:   Administrator
 * Date:     2019/7/31 14:12
 * Description: 判断系统是否为linux
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.duanzc.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 〈一句话功能简述〉<br> 
 * 〈判断系统是否为linux〉
 *
 * @author Administrator
 * @create 2019/7/31
 * @since 1.0.0
 */
public class LinuxCondition implements Condition{

    /**
     *
     * @param conditionContext  判断条件使用的上下文环境
     * @param annotatedTypeMetadata 注释信息
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获得ioc使用的BeanFactory
        conditionContext.getBeanFactory();
        //获得类加载器
        conditionContext.getClassLoader();
        //获得运行环境等信息
        conditionContext.getEnvironment();
        //判断bean的注册情况
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        System.out.println(registry.getBeanDefinitionNames());
        return conditionContext.getEnvironment().getProperty("os.name").contains("linux");
    }
}