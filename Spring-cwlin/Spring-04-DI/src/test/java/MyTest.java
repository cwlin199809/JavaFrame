import com.cwlin.pojo.Student;
import com.cwlin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.getAddress());
        //Address{address='null'}
        System.out.println(student);
        /*Student(
            name=cwlin,
            address=Address{address='null'},
            books=[红楼梦, 三国演义, 水浒传, 西游记],
            hobby=[敲代码, 听音乐, 看电影, 谈恋爱],
            card={身份证=147852963123456789, 银行卡=741852963987654321},
            games=[LOL, COC, BOB],
            wife=null,
            info={password=123456, driver=jdbc, name=root}
          )
         */
    }

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
