package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    //设置数据源
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into user(name,age,sex) values(?,?,?)",new Object[]{user.getName(),user.getAge(),user.getSex()},new int[]{
                Types.VARCHAR, Types.INTEGER, Types.TINYINT
        });
    }

    @Override
    public List<User> getUsers() {
        List list = jdbcTemplate.query("select * from user", new UserRowMapper());
        return list;
    }
}
