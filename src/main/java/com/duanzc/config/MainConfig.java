/**
 * FileName: MainConfig
 * Author:   Administrator
 * Date:     2019/7/31 10:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.duanzc.config;

import com.duanzc.condition.LinuxCondition;
import com.duanzc.condition.WindowCondition;
import com.duanzc.domain.Color;
import com.duanzc.domain.Person;
import org.springframework.context.annotation.*;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/31
 * @since 1.0.0
 */
@Configuration
//@ComponentScan(value = "com.duanzc",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class,Service.class})})


//注意jdk8之前的版本可以用@ComponentScans里面包含多个@ComponentScan
//jdk8版本可以直接写多个@ComponentScan
//FilterType.ANNOTATION按照注解
//FilterType.ASSIGNABLE_TYPE是按照指定的类型
//FilterType.ASPECTJ
//FilterType.REGEX正则
//FilterType.CUSTOM自定义
//@Conditional 如果@Conditional写在类上面代表满足了条件类的bean才能注入
@ComponentScan(value = "com.duanzc",
        includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class})
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        },
        useDefaultFilters = false)//在使用includeFilters的时候需要把useDefaultFilters为false
@Import({Color.class,MyImportSelect.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig {
    //默认的是singleton是单例模式，是在容器加载的时候实例化
    //还可以是prototype 不是单例模式，是在使用的时候进行实例化
    //针对单实例的 懒加载  @Lazy
    @Lazy
    @Scope("singleton")
    @Bean("person")//不指定方法名作为默认的id
    public Person person1(){
        System.out.println("实例化Person");
        return new Person(1,"duanzc");
    }
    @Bean("window")
    @Conditional(WindowCondition.class)
    public Person person2(){
        return new Person(2,"zhangsan");
    }

    @Bean("linux")
    @Conditional(LinuxCondition.class)
    public Person person3(){
        return new Person(3,"lisi");
    }



    /**
     * @Conditional 按照一定的条件判断，满足条件给容器注册bean
     */

    /**
     * 给容器注册组件
     * 1.包扫描+组件标注注解
     * 2.@Bean[导入第三方包的组件]
     * 3 @Import 快速的向容器中导入组件
     *      1.@Import(要导入的组件) 默认的id就是全类名
     *      2.@ImportSelect 返回需要导入的组件的全类名数组
     *      3.ImportBeanDefinitionRegistrar 通过实现ImportBeanDefinitionRegistrar手工的注册类
     * 3.使用Spring提供的FactoryBean(工厂Bean)
     *      1.默认获取到的是工厂Bean调用getObject创建一个对象
     *      2.要获取工厂Bean的本身应该在前面加上&
     */
    @Bean
    public ColorFactory colorFactory(){
        return new ColorFactory();
    }
}