package com.atguigu.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * 从键盘输入一个部门的信息，存储到atguigu库的t_department表中
 */
public class TestJDBCUtils {
    public static void main(String[] args) throws SQLException {
        //1、键盘输入
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入部门的名称：");
        String name = scanner.nextLine();

        System.out.println("请输入部门的简介：");
        String desc = scanner.nextLine();

        //2、通过工具类直接获取连接
        Connection conn = JDBCUtils.getConnection();

        //3、编写sql
        String sql = "INSERT INTO t_department VALUES(NULL,?,?);";

        //4、创建PreparedStatement
        PreparedStatement pst = conn.prepareStatement(sql);

        //5、set的?的值
        pst.setObject(1, name);
        pst.setObject(2, desc);

        //6、执行更新
        int len = pst.executeUpdate();
        System.out.println(len>0?"添加成功":"添加失败");

        //7、关闭
        pst.close();
        JDBCUtils.free();
        scanner.close();
    }
}
