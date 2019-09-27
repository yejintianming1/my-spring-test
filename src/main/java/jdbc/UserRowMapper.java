package jdbc;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet set, int i) throws SQLException {
        User u = new User(set.getLong("id"),set.getString("name"),set.getInt("age"),set.getByte("sex"));
        return u;
    }
}
