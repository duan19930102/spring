/**
 * FileName: MainConfigPropertyTest
 * Author:   Administrator
 * Date:     2019/8/1 10:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import com.duanzc.config.MainConfigAutoWired;
import com.duanzc.config.MainConfigProfile;
import com.duanzc.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/8/1
 * @since 1.0.0
 */
public class MainConfigProfileTest {

    public AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();



    public void PrintBean(AnnotationConfigApplicationContext configApplicationContext){
        String[] definitionNames = configApplicationContext.getBeanDefinitionNames();
        for(String beanName:definitionNames) {
            System.out.println(beanName);
        }
    }
    @Test
    public void test(){
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("prod","dev");
        annotationConfigApplicationContext.register(MainConfigProfile.class);
        annotationConfigApplicationContext.refresh();
        PrintBean(annotationConfigApplicationContext);



    }
}