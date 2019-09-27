package mybatis;

public interface UserMapper {

    void insertUser(User user);
    User getUser(Long id);
}
