package com.atguigu.preparedstatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * 需求：修改atguigu数据库，t_user表的"liu"这个用户的照片
 *
 * Statement的第三个问题：sql拼接不支持blob等二进制类型
 */
public class SloveProblem3 {
    public static void main(String[] args) throws Exception{
        //1、读取照片
        FileInputStream fis = new FileInputStream("E:/photo/素材/1.jpg");

        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //3、获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection conn = DriverManager.getConnection(url, "root", "123456");

        //4、编写sql
        String sql = "UPDATE t_user SET photo = ? WHERE username = 'liu';";

        //5、创建PreparedStatement
        PreparedStatement pst = conn.prepareStatement(sql);

        //6、设置？的值
        pst.setObject(1, fis);

        //7、执行sql
        int len = pst.executeUpdate();
        System.out.println(len>0?"添加成功":"添加失败");

        //8、关闭
        pst.close();
        conn.close();

    }
}
