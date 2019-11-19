package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private User user;

    @Override
    public User queryUserById(String id) {
        user.setId("1");
        user.setName("jack");
        user.setPassword("1234");
        return user;
    }
}
