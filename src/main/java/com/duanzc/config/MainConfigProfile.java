package com.duanzc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile
 *      Spring中为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *
 * @Profile 指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境都能注册这个组件
 *
 * 1)加了环境标识的bean,只有这个环境被激活的时候才能注册到容器中，默认是default环境
 * 2)写在配置类上，只有指定的环境，整个配置类才生效
 * 3)没有标注环境标识的组件，在任何环境都被注入的
 *
 * 切换环境
 * 1.使用命令行动态参数
 * 在虚拟机参数位置加载 -Dspring.profiles.active=test
 * 2.使用代码的方式
 *      a.创建一个无参的applicationContext
 *      b.设置需要激活的环境
 *      c.注册配置类
 *      d.启动刷新容器
 *
 *
 */
@Profile("test")
@PropertySource("classpath:/dataSource.properties")
@Configuration
public class MainConfigProfile implements EmbeddedValueResolverAware {
    @Value("${db.user}")
    private String user;

    private StringValueResolver valueResolver;

    private String driverName;

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}")String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword("root123");
        dataSource.setJdbcUrl("jdbc:mysql//localhost:3306/ry");
        dataSource.setDriverClass(driverName);
        return dataSource;
    }
    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}")String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql//localhost:3306/ry");
        dataSource.setDriverClass(driverName);
        return dataSource;
    }
    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}")String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql//localhost:3306/ry");
        dataSource.setDriverClass(driverName);
        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
        driverName = valueResolver.resolveStringValue("${db.driver}");
    }
}
