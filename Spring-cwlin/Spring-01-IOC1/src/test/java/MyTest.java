import com.cwlin.dao.UserDaoMysqlImpl;
import com.cwlin.dao.UserDaoOracleImpl;
import com.cwlin.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
        //用户实际调用的是业务层，Dao层他们不需要接触
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
        userService.setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
