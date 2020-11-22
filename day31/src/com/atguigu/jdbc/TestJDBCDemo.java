package com.atguigu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 需求：要用java代码添加一个部门到数据库atguigu库中的t_department中
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
 */
public class TestJDBCDemo {
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
        String sql = "INSERT INTO t_department VALUES(NULL, '测试部门', '测试数据')";
        //要把sql语句发给服务器端执行，并接受他返回的结果
        //（2）创建Statement对象
        Statement st = conn.createStatement();
        //（3）用Statement对象，执行sql，并接收结果
        int len = st.executeUpdate(sql);//凡是insert,update,delete语句都是更新数据库，凡是select都是查询query
        //返回len的值表示len行受到影响

        System.out.println(len>0?"添加成功":"添加失败");

        //4、关闭连接
        st.close();
        conn.close();
    }
}
