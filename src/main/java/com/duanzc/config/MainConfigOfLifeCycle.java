/**
 * FileName: MainConfigOfLifeCycle
 * Author:   Administrator
 * Date:     2019/7/31 15:30
 * Description: Bean的生命周期
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.duanzc.config;

import com.duanzc.domain.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Bean的生命周期〉
 *
 * @author Administrator
 * @create 2019/7/31
 * @since 1.0.0
 */
@Configuration
@ComponentScan("com.duanzc")
public class MainConfigOfLifeCycle {
    @Bean(value = "car",initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }

    /**
     * Bean的生命周期
     * 创建----初始化-----销毁
     * 我们可以自定义初始化和销毁的方法
     *
     * 构造：
     *      单实例：在容器每次启动时创建对象
     *      多实例：每次获取对象的时候进行创建
     * 初始化：
     *      对象创建完成，并赋值好，调用初始化方法
     *
     *  销毁
     *      单实例：在容器关闭的时候进行销毁
     *      多实例：容器不会进行销毁的
     *
     *
     *  方式1
     *      指定init-method和destory-method
     *  方式2
     *      通过实现InitializingBean(定义初始化逻辑)
     *      通过实现DisposableBean(定义销毁的方法)
     * 方式3可使用JSR250
     *  @PostConstruct 在bean创建完成并且属性复制完成，来执行初始化
     *  @PreDestroy 在容器销毁bean之前通知做清理工作
     *
     *  方法4 [interface]BeanPostProcessor: bean的后置处理器
     *  在bean初始化前后进行一些处理工作
     *  postProcessBeforeInitialization  初始化之前
     *  postProcessAfterInitialization   初始化之后
     */


}