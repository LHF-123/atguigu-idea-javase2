package com.atguigu.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * mysql默认自动提交事务，执行一句，提交一句
 *
 * 模拟：一个事务有两条语句，希望他们要么同时成功，要么同时失败
 * （1）sql：用于更新atguigu库的t_department表的“后勤服务部”的名称改为“xx”
 * （2）sql：用于添加atguigu库的t_department表的"yy","yyy"
 *
 * 和事务相关的API
 * （1）Connection连接对象需要修改为“手动提交”
 * （2）如果一切正常，Connection连接对象.commit()
 *      如果有问题，Connection连接对象.rollback()
 *
 * 注意：
 * （1）同一个事务的sql必须保证是同一个Connection对象
 * （2）在执行sql之前 Connection连接对象.setAutoCommit(false);
 * （3）执行sql
 * （4）如果没有异常，一切正常，Connection连接对象.commit()
 * （5）如果有问题，Connection连接对象.rollback()
 * （6）关闭连接之前请使用Connection连接对象.setAutoCommit(true);
 * （7）关闭连接 Connection连接对象.close();
 */
public class TestTransaction {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2、获取连接
            String url = "jdbc:mysql://localhost:3306/atguigu";
            conn = DriverManager.getConnection(url, "root", "123456");

            //加一步：设置手动提交
            conn.setAutoCommit(false);

            update(conn);//成功
            insert(conn);//失败,故意写错

            conn.commit();
            System.out.println("成功");
        } catch (Exception e) {
            System.out.println("失败");
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                //为了和后面的代码保持一致，这里建议加一句代码，因为后面的连接对象可能是重复利用的
                conn.setAutoCommit(true);
                conn.close();//现在的关闭时真正的关闭，后面conn如果是从连接池中获取的重复利用的对象的话，这个关闭就变成还给连接池
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    public static void update(Connection conn) throws Exception{
        //3、编写sql
        String sql = "UPDATE t_department SET dname = ? WHERE dname = ?";

        //4、创建PreparedStatement
        PreparedStatement pst = conn.prepareStatement(sql);

        //5、设置？的值
        pst.setObject(1, "xx");
        pst.setObject(2, "后勤服务部");

        //6、执行sql
        int len = pst.executeUpdate();


        pst.close();

    }

    public static void insert(Connection conn) throws Exception{
        //3、编写sql
        String sql = "INSERT INTO t_department VALU(NULL, ?, ?)";//故意把values写成valu，造成sql执行失败

        //4、创建PreparedStatement
        PreparedStatement pst = conn.prepareStatement(sql);

        //5、设置？的值
        pst.setObject(1, "yy");
        pst.setObject(2, "yyy");

        //6、执行sql
        int len = pst.executeUpdate();

        ///8、关闭
        pst.close();

    }
}
