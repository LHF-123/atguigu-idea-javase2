package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
 * 问题1：注册驱动，获取连接等写了很多遍
 * 问题2：我们每次都从数据库获取新的连接
 * mysql是一个TCP/IP协议的网络，那么：
 * （1）每获取一次新的连接的成本很高，需要“三次握手”，断开需要“四次挥手”
 * （2）每一个客户端都有单独的线程来维护他的通信
 *  这样就会造成如果有很多的客户端同时去连接mysql服务器，会造成
 *  （1）mysql的并发量就有危险，如果太多就会挂了
 *      特别是一些程序员，获取完连接，没有关闭
 *  （2）每次高成本获取的连接只用一次，太奢侈了，我们希望可以重复使用
 *
 * 解决：
 * （1）解决问题1：我们把注册驱动，获取连接等方法，封装到一个工具类中，减少代码
 * （2）解决问题2：我们可以使用“数据库连接池”来解决
 *
 * 数据库连接池技术：
 * （1）先创建一个连接池pool，然后在池中先放一些连接对象，然后程序去获取连接对象时，用现有的对象，会更快
 *      例如：从自来水新接一桶水，没有从池中直接“装”一桶水快
 *
 * （2）然后我们可以设置连接池的最大连接数量，如果池中的所有连接都在使用的话，那么可以让“客户端”等待，
 *      虽然有等待的现象，但总比“挂”了好。
 *
 * （3）创建连接池时，一开始是初始化少量的连接，等用户并发量上来后，会增加连接数，直到最高连接数为止。
 *
 * （4）之前conn.close()真正的与服务器断开连接，现在从连接池中拿连接对象，关闭时是还给了连接池。
 *
 * 连接池技术有很多，我们讲的是德鲁伊，他是阿里的
 *
 * 使用步骤：
 * （1）导入"德鲁伊"jar
 *      druid-1.1.10.jar
 *
 * （2）加一个配置文件
 *      配置"德鲁伊"连接池的参数
 *
 *  明确：数据库连接池的作用，管理连接
 *      为了获取连接，需要哪些参数：主机名、端口号、用户名、密码、驱动类名
 *          其他参数：初始化连接数、最多连接数...
 *
 * 在src下建一个druid.properties文件
 * url=jdbc:mysql://localhost:3306/atguigu?rewriteBatchedStatements=true
   username=root
   password=123456
   driverClassName=com.mysql.jdbc.Driver
   initialSize=10
   maxActive=20
   maxWait=1000
   filters=wall
 *
 * （3）创建连接池（一个系统一个）
 *
 *  javax.sql.DataSource
 *
 * （4）提供一个方法，可以从连接池中拿连接对象
 * （5）提供一个关闭连接的方法
 */
public class JDBCUtils {
    private static DataSource ds;
    private static ThreadLocal<Connection> local;

    static {
        try {
            //静态代码块可以初始化静态变量
            //把src下建一个druid.properties文件的数据，加载到一个Properties对象中
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

            ds = DruidDataSourceFactory.createDataSource(pro);

            local = new ThreadLocal<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //这个代码不能保证同一个线程（客户端）共享同一个连接对象，加载到一个Properties对象中
    /*public static Connection getConnection() throws SQLException {
        //这里只是改变获取连接的代码
        return ds.getConnection();
    }*/

    //这里修改为用ThreadLocal来保存同一个线程的共享变量
    public static Connection getConnection() throws SQLException {
        //这里只是改变获取连接的代码
        Connection conn = local.get();//如果从local中能得到一个连接对象，那么说明当前线程已经拿过了
        if (conn == null){//如果不能得到一个连接对象，那么说明当前线程没拿过
            conn = ds.getConnection();
            local.set(conn);
        }
        return conn;
    }

    //提供关闭连接的方法
    public static void free(){
        try {
            Connection conn = local.get();
            if (conn != null){
                local.remove();
                conn.setAutoCommit(true);//还原我们的连接为自动提交模式，等别人再次拿到这个连接是，就可以默认是自动提交
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static DataSource getDs() {
        return ds;
    }
}
