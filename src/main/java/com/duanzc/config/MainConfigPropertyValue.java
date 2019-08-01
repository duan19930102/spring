/**
 * FileName: MainConfigPropertyValue
 * Author:   Administrator
 * Date:     2019/8/1 10:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.duanzc.config;

import com.duanzc.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/8/1
 * @since 1.0.0
 */
@PropertySource(value = {"classpath:/person.properties"},encoding = "utf-8")
@Configuration
public class MainConfigPropertyValue {
    @Bean
    public Person person(){
        return new Person();
    }

}