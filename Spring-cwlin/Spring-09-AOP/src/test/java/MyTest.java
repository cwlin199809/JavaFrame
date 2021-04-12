import com.cwlin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //注意：动态代理，它代理的是接口
        UserService userService = context.getBean("userService", UserService.class);
        //业务实现
        userService.insert();
        userService.delete();
        userService.update();
        userService.select();
    }
}
