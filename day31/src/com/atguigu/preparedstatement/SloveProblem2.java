package com.atguigu.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/*
 * 需求：从键盘输入员工信息，根据姓名到atguigu数据库的t_employee表中查询自己的个人信息
 *
 * Statement的第二个问题：sql注入，盗窃信息
 * PreparedStatement可以避免
 */
public class SloveProblem2 {
    public static void main(String[] args) throws Exception{
        //键盘输入
        Scanner input = new Scanner(System.in);

        System.out.println("请输入姓名：");
        String ename = input.nextLine();

        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //3、获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection conn = DriverManager.getConnection(url, "root", "123456");

        //4、编写sql
//        String sql = "SELECT * FROM t_employee WHERE ename = '" + ename + "';";//孙红雷' or '1' = '1
        String sql = "SELECT * FROM t_employee WHERE ename = ?;";
        //SELECT * FROM t_employee WHERE ename = '孙红雷' or '1' = '1';

        //5、创建PreparedStatement
        PreparedStatement pst = conn.prepareStatement(sql);

        //6、把?的具体指传进去
        pst.setObject(1,ename);

        //7、执行sql
        ResultSet set = pst.executeQuery();
        while (set.next()){
            for (int i = 1; i <= 10; i++) {
                System.out.print(set.getObject(i) + "\t");
            }
            System.out.println();
        }

        //8、关闭
        set.close();
        pst.close();
        conn.close();
        input.close();

    }
}
