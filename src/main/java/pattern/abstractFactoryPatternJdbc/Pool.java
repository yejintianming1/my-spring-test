package pattern.abstractFactoryPatternJdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public abstract class Pool {

    public String propertiesName = "connection-INF.properties";
    private static Pool instance = null;//定义唯一实例
    protected int maxConnect = 100; //最大连接数
    protected int normalConnect = 10;//保持连接数
    protected String driverName = null;//驱动字符串
    protected Driver driver = null;//驱动变量

    // 私有构造函数，不允许外界访问
    protected Pool() {
        try {
            init();
            loadDrivers(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 装载和注册所有JDBC驱动程序
    protected void loadDrivers(String driverName) {
        String driverClassName = driverName;
        try {
            driver = (Driver) Class.forName(driverClassName).newInstance();
            DriverManager.registerDriver(driver);
            System.out.println("成功注册JDBC驱动程序"+driverClassName);
        } catch (Exception e) {
            System.out.println("无法注册JDBC驱动程序："+driverClassName+",错误："+e);
        }
    }

    // 初始化所有从配置文件中读取的成员变量
    private void init() throws IOException {
        InputStream is = Pool.class.getResourceAsStream(propertiesName);
        Properties p = new Properties();
        p.load(is);
        this.driverName = p.getProperty("driverName");
        this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
    }

    //创建连接池
    public abstract void createPool();

    // 返回数据库连接池Pool的实例
    public static synchronized Pool getInstance() throws Exception {
        if (instance == null) {
            instance.init();
            instance = (Pool) Class.forName("pattern.abstractFactoryPatternJdbc.Pool").newInstance();
        }
        return instance;
    }

    //获取一个可用的连接，如果没有则创建一个连接，且小于最大连接限制
    public abstract Connection getConnection();

    //获得一个连接，有时间限制
    public abstract Connection getConnection(long time);

    //将连接对象返回给连接池
    public abstract void freeConnection(Connection con);

    //返回当前空闲连接数
    public abstract int getNum();

    //返回当前工作的连接数
    public abstract int getNumActive();

    protected synchronized void release() {
        //撤销驱动
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("撤销JDBC驱动程序"+driver.getClass().getName());
        } catch (Exception e) {
            System.out.println("无法撤销JDBC驱动程序的注册："+driver.getClass().getName());
        }
    }



}
