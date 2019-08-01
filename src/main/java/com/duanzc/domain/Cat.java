/**
 * FileName: Cat
 * Author:   Administrator
 * Date:     2019/7/31 16:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.duanzc.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/31
 * @since 1.0.0
 */
@Component
public class Cat implements InitializingBean,DisposableBean{
    public Cat(){
        System.out.println("猫的构造");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("猫的初始化");
    }

    public void destroy() throws Exception {
        System.out.println("cat destroy");
    }
}