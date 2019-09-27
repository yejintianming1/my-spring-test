package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class MyBatisTest {

    static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
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
