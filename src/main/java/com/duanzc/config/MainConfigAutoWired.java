/**
 * FileName: MainConfigAutoWired
 * Author:   Administrator
 * Date:     2019/8/1 11:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.duanzc.config;

import com.duanzc.dao.BookDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自动装配〉
 *
 * Spring利用依赖注入(DI) 完成对IOC中各个组件的依赖关系的赋值
 * 1)
 * 1.默认优先按照类型去容器中找对应的组件applicationContext.getBean(BookDao.class)
 * 2.如果有对个类型相同的组件，再将属性的名称作为组件id去容器中查找
 *   applicationContext.getBean("bookDao")
 * 3.@Qualifier("bookDao") 使用@Qualifier指定需要装配组件id,而不是属性名
 * 4.自动装配默认一定要降属性赋值好，没有就会报错
 *  可以使用@Autowired(resquest=false)
 * 5.@Primary 让Spring进行自动装配对象时候，默认使用首选bean
 *  也可以继续使用Qualifier指定需要装配名字的bean
 *
 * 2)
 * Spring还支持使用@Resource(JSR250)和@Inject@(JSR330)java规范注解
 * @Resource可以和@Autowired一样实现自动装配功能，默认是按照名称进行装配的
 * 没有能支持@Primary功能也没有支持@Autowired(request=false)
 *
 * @Inject
 *      需要导入javax.inject的包和Autowired功能一样，没有没有支持@Autowired(request=false)
 *
 * //默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
 * 3）@Autowired：构造器，参数，方法，属性：都是从容器中获取参数组件的值
 *   1）[标注在方法位置] @Bean+方法参数
 *   2）[标注在构造器上] 如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置
 *   的组件还是可以自动从容器中获取
 *   3）放在参数上
 *
 * 4）自定义的组件想要使用Spring容器底层的一些组件（ApplicationContext,BeanFacotry,
 *      让自定义实现xxxAware接口）在创建对象的时候，会调用接口规定的方法注入相关的组件
 *      xxxAware：功能使用对应的xxxxProcessor处理的
 *
 *
 *
 *
 *
 * @author Administrator
 * @create 2019/8/1
 * @since 1.0.0
 */
@ComponentScan({"com.duanzc.service","com.duanzc.dao","com.duanzc.controller"})
@Configuration
public class MainConfigAutoWired {
    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

}