/**
 * FileName: MyTypeFilter
 * Author:   Administrator
 * Date:     2019/7/31 11:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.duanzc.config;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/31
 * @since 1.0.0
 */
public class MyTypeFilter implements TypeFilter {
    //MetadataReader 读取正在扫描类的信息
    //MetadataReaderFactory 可以获得其他类的信息
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解信息
        metadataReader.getAnnotationMetadata();
        //获取当前扫描类的类的信息
        metadataReader.getClassMetadata();
        //获取当前扫描类的资源信息 比如类路径的信息
        metadataReader.getResource();
        String className =  metadataReader.getClassMetadata().getClassName();
        if(className.contains("er")) {
            return true;
        }

        return false;
    }
}