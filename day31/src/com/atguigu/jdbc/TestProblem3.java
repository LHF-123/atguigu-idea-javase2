package com.atguigu.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * 需求：修改atguigu数据库，t_user表的"liu"这个用户的照片
 *
 * Statement的第三个问题：sql拼接不支持blob等二进制类型
 */
public class TestProblem3 {
    public static void main(String[] args) throws Exception{
        //1、读取照片
        FileInputStream fis = new FileInputStream("E:/photo/素材/1.jpg");

        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //3、获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection conn = DriverManager.getConnection(url, "root", "123456");

        //4、编写sql
        String sql = "UPDATE t_user SET photo = " + fis + " WHERE username = 'liu';";

        //5、创建Statement
        Statement st = conn.createStatement();

        //6、执行sql
        int len = st.executeUpdate(sql);
        System.out.println(len>0?"添加成功":"添加失败");

        //7、关闭
        st.close();
        conn.close();

    }
}
