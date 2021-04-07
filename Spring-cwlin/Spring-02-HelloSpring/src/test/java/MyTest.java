import com.cwlin.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取Spring的上下文对象！
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //对象都在Spring中管理，当使用时，直接从Spring中取出即可！
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
