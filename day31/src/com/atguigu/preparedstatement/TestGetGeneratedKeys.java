package com.atguigu.preparedstatement;

import java.sql.*;
import java.util.Scanner;

/**
 * @author LHF
 * @create 2020-09-05-15:04
 *
 * 需求：从键盘输入一个部门的名称和简介，添加到atguigu数据库的t_department表中
 *      因为部门编号是自增长，我希望添加成功后，直接获取该部门的编号。
 *
 * Statement是PreparedStatement的父接口
 * 在Statement有一个常量值：RETURN_GENERATED_KEYS
 *
 * 步骤：特殊
 * （1）PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
 * （2）执行完sql后
 *      ResultSet set = pst.getGeneratedKeys();
 */
public class TestGetGeneratedKeys {
    public static void main(String[] args) throws Exception{
        //1、键盘输入
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入部门的名称：");
        String name = scanner.nextLine();

        System.out.println("请输入部门的简介：");
        String desc = scanner.nextLine();

        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //3、获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection conn = DriverManager.getConnection(url, "root", "123456");

        //4、编写sql
        String sql = "INSERT INTO t_department VALUES(NULL, ?, ?)";

        //5、创建PreparedStatement
        //Statement.RETURN_GENERATED_KEYS表示执行完sql后，带回自增长的键值
        PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        //6、设置？的值
        pst.setObject(1, name);
        pst.setObject(2, desc);

        //7、执行sql
        int len = pst.executeUpdate();
        System.out.println(len>0?"添加成功":"添加失败");

        ResultSet set = pst.getGeneratedKeys();//获取自增长的键值，被包装在一个ResultSet的结果集中
        if (set.next()){//因为自增长的键值只有一个单值
            System.out.println("部门编号：" + set.getObject(1));
        }

        //8、关闭
        set.close();
        pst.close();
        conn.close();
        scanner.close();
    }
}
