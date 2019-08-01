/**
 * FileName: Person
 * Author:   Administrator
 * Date:     2019/7/31 9:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.duanzc.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/31
 * @since 1.0.0
 */

public class Person {
    /**
     * 使用Value复制
     * 1.基本类型
     * 2.可以写SpEl #{}
     * 3.可以写${},可以获取到配置文件中的值
     *
     * 在使用@PropertySource(value = {"classpath:/person.properties"},encoding = "utf-8") 读取配置文件的时候自己犯了两个错
     * 1.将@PropertySource写在了Bean类上而不是配置文件类
     * 2.没有设置字符集造成乱码
     */
    @Value("#{20-2}")
    private int id;
   // @Value("张三")
    @Value("${person.name}")
    private String name;

    public Person(){
        System.out.println("实例化Person");
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}