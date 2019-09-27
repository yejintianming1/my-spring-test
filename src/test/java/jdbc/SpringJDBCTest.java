package jdbc;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringJDBCTest extends TestCase {

    @Test
    public void test() {
        ApplicationContext act = new ClassPathXmlApplicationContext("jdbc/bean.xml");
        UserService userService = (UserService) act.getBean("userService");
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setSex(Byte.parseByte("1"));
        // 保存一条记录
        userService.save(user);
        List<User> users = userService.getUsers();
        System.out.println("+++++++++++得到所有User");
        for (User u:users
             ) {
            System.out.println(u.getId()+" "+u.getName()+" "+u.getAge()+" "+u.getSex());
        }



    }
}
