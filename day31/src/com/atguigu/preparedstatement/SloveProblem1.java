package com.atguigu.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
 * 需求：从键盘输入员工信息，并添加到test数据库的t_employee表中
 *
 * Statement的第一个问题：需要sql的拼接
 * PreparedStatement可以避免
 */
public class SloveProblem1 {
    public static void main(String[] args) throws Exception{
        //键盘输入
        Scanner input = new Scanner(System.in);

        System.out.println("请输入姓名：");
        String ename = input.nextLine();

        System.out.println("请输入电话：");
        String tel = input.nextLine();

        System.out.println("请输入性别：");
        String gender = input.nextLine();

        System.out.println("请输入薪资：");
        String salaryStr = input.nextLine();
        double salary = Double.parseDouble(salaryStr);

        //...其他字段暂时省略

        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //3、获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection conn = DriverManager.getConnection(url, "root", "123456");

        //4、编写sql
        String sql = "INSERT INTO t_employee(ename, tel, gender, salary) VALUES(?,?,?,?);";

        //5、创建PreparedStatement
//        Statement st = conn.createStatement();
        PreparedStatement pst = conn.prepareStatement(sql);

        //6、把?的具体指传进去
        pst.setObject(1, ename);//序号也是从1开始
        pst.setObject(2, tel);
        pst.setObject(3, gender);
        pst.setObject(4, salary);

        //7、执行sql
//        int len = st.executeUpdate(sql);
        int len = pst.executeUpdate();//这里不能再传sql了
        System.out.println(len>0?"添加成功":"添加失败");

        //8、关闭
//        st.close();
        pst.close();
        conn.close();
        input.close();

    }
}
