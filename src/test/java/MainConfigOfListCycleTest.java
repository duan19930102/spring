/**
 * FileName: MainConfigOfListCycleTest
 * Author:   Administrator
 * Date:     2019/7/31 16:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import com.duanzc.config.MainConfigOfLifeCycle;
import com.duanzc.domain.Car;
import com.duanzc.domain.Cat;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/31
 * @since 1.0.0
 */
public class MainConfigOfListCycleTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Test
    public void testInitandDestroy(){
       Cat cat = (Cat) context.getBean("cat");
       context.close();

    }

}