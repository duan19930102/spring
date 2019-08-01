/**
 * FileName: MainTest
 * Author:   Administrator
 * Date:     2019/7/31 10:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import com.duanzc.config.ColorFactory;
import com.duanzc.config.MainConfig;
import com.duanzc.domain.Blue;
import com.duanzc.domain.Person;
import org.junit.Test;
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
public class MainTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    public void testPerson(){
        //测试@Bean注解
//        ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(MainConfig.class);
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person.toString());

        //测试@ComponentScan注解的
        ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) applicationContext.getBean("person");
        String[] beans = applicationContext.getBeanDefinitionNames();
        for(String s:beans){
            System.out.println(s);
        }
    }
    @Test
    public void testBeanScope(){
        //
        System.out.println("启动完成");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("容器加载完毕");
        System.out.println("实例化开始");
        Person person1 = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");
        System.out.println(person1==person2);
    }
    @Test
    public void testCondition(){
        String osName = applicationContext.getEnvironment().getProperty("os.name");
        System.out.println(osName);

        String[] beansName = applicationContext.getBeanNamesForType(Person.class);
        for(String beanName:beansName){
            System.out.println(beanName);
        }

    }
    @Test
    public void testImport(){
        String[] beansName = applicationContext.getBeanDefinitionNames();
        for(String beanName:beansName) {
            System.out.println(beanName);
        }

//        Blue blue = (Blue) applicationContext.getBean("com.duanzc.domain.Blue");
//        System.out.println(blue);

        Object a = applicationContext.getBean("colorFactory");
        System.out.println(a);
    }

}