package mybatis;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyBatisCodeTest {

    static SqlSessionFactory sqlSessionFactory = null;
    static {
        Configuration config = new Configuration();


        sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
    }

    @Test
    public void testAdd() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User("tom",new Integer(5));
            userMapper.insertUser(user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void testGetUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(1L);
            System.out.println("name: "+user.getName()+"|age: "+user.getAge());
        } finally {
            sqlSession.close();
        }
    }
}
