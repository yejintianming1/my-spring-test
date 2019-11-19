package springmvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class UserController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> userList = new ArrayList<>();
        User userA = new User();
        User userB = new User();
        userA.setUsername("张三");
        userA.setAge(28);
        userB.setUsername("李四");
        userB.setAge(38);
        userList.add(userA);
        userList.add(userB);
        return new ModelAndView("userList","users",userList);
    }
}
