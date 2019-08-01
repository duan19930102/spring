/**
 * FileName: Dog
 * Author:   Administrator
 * Date:     2019/7/31 16:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.duanzc.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/31
 * @since 1.0.0
 */
@Component
public class Dog {
    public Dog(){

    }
    @PostConstruct
    public void init(){
        System.out.println("Dog。。。。PostConstruct");
    }
    @PreDestroy
    public void destory(){
        System.out.println("Dog.......PreDestroy");
    }
}