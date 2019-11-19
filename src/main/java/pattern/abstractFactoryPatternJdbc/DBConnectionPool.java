package pattern.abstractFactoryPatternJdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class DBConnectionPool extends Pool {

    private int checkOut;//正在使用的连接数
    private Vector<Connection> freeConnections = new Vector<Connection>();//存放产生的连接对象容器
    private String password = null;//密码
    private String url = null;//连接字符串
    private String userName = null;//用户名
    private static int num = 0;//空闲连接数
    private static int numActive = 0;//当前可用的连接数
    private static DBConnectionPool pool = null;//连接池实例变量

    //产生数据连接池
    public static synchronized DBConnectionPool getInstance() {
        if (pool == null) {
            pool = new DBConnectionPool();
        }
        return pool;
    }

    //获得一个数据库连接池的实例
    private DBConnectionPool() {
        try {
            init();
            for (int i = 0; i < normalConnect; i++) {//初始化normalConn个连接
                Connection c = newConnection();
                if (c != null) {
                    freeConnections.addElement(c);//往容器中添加一个连接对象
                    num++;//记录总连接数
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //初始化
    private void init() throws IOException {
        InputStream is = DBConnectionPool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.userName = p.getProperty("userName");
        this.password = p.getProperty("password");
        this.driverName = p.getProperty("driverName");
        this.url = p.getProperty("url");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }



    //创建一个新连接
    private Connection newConnection() {
        Connection con = null;
        try {
            if (userName == null) {//用户、密码都为空
                con = DriverManager.getConnection(url);
            } else {
                con = DriverManager.getConnection(url,userName,password);
            }
            System.out.println("连鸡翅创建一个新的连接");
        } catch (SQLException e) {
            System.out.println("无法创建这个URL的连接"+url);
            return null;
        }
        return con;
    }


    @Override
    public void createPool() {
     pool = new DBConnectionPool();
     if (pool != null) {
         System.out.println("创建连接池成功");
     } else {
         System.out.println("创建连接池失败");
     }
    }

    //获取一个可用连接
    @Override
    public Connection getConnection() {
        Connection con = null;
        if (freeConnections.size()>0) {//还有空闲的连接
            num--;
            con = (Connection) freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            try {
                if (con.isClosed()) {
                    System.out.println("从连接池中删除一个无效连接");
                    con = getConnection();
                }
            } catch (SQLException e) {
                System.out.println("从连接池中删除一个无效连接");
                con = getConnection();
            }
        } else if (maxConnect == 0 || checkOut < maxConnect) {//没有空闲连接且当前连接小于最大允许值，最大值为0则不限制
            con = newConnection();
        }
        if (con != null) {//当前连接数加1
            checkOut++;
        }
        numActive++;
        return con;
    }

    //获取一个连接，并加上等待时间限制，单位为毫秒
    @Override
    public synchronized Connection getConnection(long timeout) {
        long startTime = new Date().getTime();
        Connection con;
        while ((con = getConnection()) == null) {
            try {
                wait(timeout);//线程等待
            } catch (InterruptedException e) {
            }
            if ((new Date().getTime() -startTime) >= timeout) {
                return null;//如果超时，则返回
            }
        }
        return con;
    }

    //如果不再使用某个连接对象，可调用此方法将该对象释放到连接池
    @Override
    public void freeConnection(Connection con) {
        freeConnections.addElement(con);
        num++;
        checkOut--;
        numActive--;
        notifyAll();//解锁
    }

    //返回当前空闲连接数
    @Override
    public int getNum() {
        return num;
    }

    //返回当前连接数
    @Override
    public int getNumActive() {
        return numActive;
    }

    //关闭所有连接
    public synchronized void release() {
        try {
            //将当前连接赋值到枚举中
            Enumeration<Connection> allConnections = freeConnections.elements();
            while (allConnections.hasMoreElements()) {
                //如果此枚举对象至少还有一个可提供的元素，则返回此枚举对象的下一个元素
                Connection con = (Connection) allConnections.nextElement();
                try {
                    con.close();
                    num--;
                } catch (SQLException e) {
                    System.out.println("无法关闭连接池中的连接");
                }
            }
            freeConnections.removeAllElements();
            numActive = 0;
        } finally {
            super.release();
        }
    }
}
