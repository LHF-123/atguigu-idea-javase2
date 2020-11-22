package com.atguigu.jdbc;

import java.sql.*;

/*
 * 需求：要用java代码查询数据库atguigu库中的t_department表中所有数据
 *
 * 1、注册驱动，加载驱动类到内存中，即在内存中有驱动类的Class对象
 *
 * 2、获取连接，即登录
 *  URL：网址，统一资源定位符
 *
 *  http://localhost:8080/res/index.jsp
 *  协议//主机地址:端口号/文件路径
 *
 *  mysql:
 *  jdbc:子协议://主机地址:端口号/数据库名
 *  jdbc:mysql://localhost:3306/atguigu
 *
 *  3、传sql
 *
 * API：java.sql包
 *  1、Connection接口：代表连接
 *  2、DriverManager：驱动管理类
 *      getConnection(xx)
 *  3、Statement
 *      int executeUpdate(sql)
 *      ResultSet executeQuery(sql)
 *  4、ResultSet
 *      boolean hasNext()
 *      XXX nextXxx
 */
public class TestJDBCDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、注册驱动
//        Class.forName("org.git.mm.mysql.Driver");//旧版驱动
        Class.forName("com.mysql.jdbc.Driver");//新版驱动

        //2、获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        String user = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, user, password);

        //3、执行sql
        //（1）编写sql
        String sql = "SELECT did, dname, description FROM t_department";
        //要把sql语句发给服务器端执行，并接受他返回的结果
        //（2）创建Statement对象
        Statement st = conn.createStatement();
        //（3）用Statement对象，执行sql，并接收结果
        ResultSet set = st.executeQuery(sql);
        //（4）遍历结果集
        while (set.next()){//等价于集合的Iterator的hasNext()
            /*int id = set.getInt("did");//根据字段名取结果
            String name = set.getString("dname");
            String desc = set.getString(3);//也可以根据字段的序号，从1开始，取结果
            System.out.println(id + "\t" + name + "\t" + desc);*/

            Object id = set.getObject(1);
            Object name = set.getObject(2);
            Object desc = set.getObject(3);
            System.out.println(id + "\t" + name + "\t" + desc);
        }

        //4、关闭连接
        set.close();
        st.close();
        conn.close();
    }
}
