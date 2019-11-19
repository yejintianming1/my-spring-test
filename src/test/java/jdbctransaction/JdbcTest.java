package jdbctransaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {

    @Test
    public void test() throws Exception {

        ApplicationContext act = new ClassPathXmlApplicationContext("jdbctransaction/bean.xml");

        UserService userService = (UserService) act.getBean("userService");
        User user = new User();
        user.setName("张三ccc");
        user.setAge(20);
        user.setSex("男");
        //保存一条记录
        userService.save(user);

    }
}
