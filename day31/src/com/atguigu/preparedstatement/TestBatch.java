package com.atguigu.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * 批处理：
 *  例如：从excle等文件，获取老数据库中把数据迁移到当前的数据库中
 *  例如：现在模拟，在部门表中添加1000条测试数据
 *
 *  1、addBatch()：把sql添加到批处理命令中，先缓存起来
 *  2、executeBatch()：执行批量处理语句，一起执行
 *
 * 特别要注意：
 * （1）在url后面加一个参数：rewriteBatchedStatements=true
 * （2）添加语句不要用value，用values
 */
public class TestBatch {
    public static void main(String[] args) throws Exception{
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、获取连接
        String url = "jdbc:mysql://localhost:3306/atguigu?rewriteBatchedStatements=true";
        Connection conn = DriverManager.getConnection(url, "root", "123456");

        //3、编写sql
        String sql = "INSERT INTO t_department VALUES(NULL, ?, ?)";

        //4、创建PreparedStatement
        PreparedStatement pst = conn.prepareStatement(sql);

        //5、设置？的值
        //这里循环产生一些模拟数据
        for (int i = 1; i <= 1000; i++) {
            pst.setObject(1, "测试部门名称" + i);
            pst.setObject(2, "测试部门简介" + i);

            pst.addBatch();//先添加到批处理命令组，先缓存。如果缓存区满了，会自动执行一批
        }

        //返回1000个结果
        int[] results = pst.executeBatch();
        System.out.println(results.length);

        //7、关闭
        pst.close();
        conn.close();
    }
}
