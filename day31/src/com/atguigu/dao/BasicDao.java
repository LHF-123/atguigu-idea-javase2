package com.atguigu.dao;

import com.atguigu.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 * @author LHF
 * @create 2020-09-05-21:07
 *
 * DAO:Data Access Object  数据访问接口和相关的类
 *
 * 把各个DAO的实现类的相同代码提取出来
 *
 * java.sql.ResultSetMetaData类型：结果集的元数据类型
 */
public class BasicDao {

    //适用于insert,update,delete语句
    public int update(String sql, Object... param) throws Exception {
        //1、获取连接
        Connection conn = JDBCUtils.getConnection();

        //2、创建PreparedStatement
        PreparedStatement pst = conn.prepareStatement(sql);

        //3、设置？的值
        if (param != null && param.length > 0){
            for (int i = 0; i < param.length; i++) {//数组下标从0开始
                pst.setObject(i+1, param[i]);//?的序号从1开始
            }
        }

        //4、执行更新sql
        int len = pst.executeUpdate();

        //5、关闭
        pst.close();
        JDBCUtils.free();

        //6、返回结果
        return len;
    }

    //T可能代表Department，Employee等各种JavaBean的对象
    //clazz是决定你查询的结果是Department，Employee类型中的哪个对象
    public <T> ArrayList<T> getAll(Class<T> clazz, String sql, Object... param) throws Exception{
        //1、获取连接
        Connection conn = JDBCUtils.getConnection();

        //2、创建PreparedStatement
        PreparedStatement pst = conn.prepareStatement(sql);

        //3、设置？的值
        if (param != null && param.length > 0){
            for (int i = 0; i < param.length; i++) {//数组下标从0开始
                pst.setObject(i+1, param[i]);//?的序号从1开始
            }
        }

        //4、执行查询
        ResultSet rs = pst.executeQuery();

        //获取结果集的元数据对象，该对象有对结果集的数据进行描述的相关信息
        ResultSetMetaData rsm = rs.getMetaData();

        //(1)获取结果集的列数
        int count = rsm.getColumnCount();

        ArrayList<T> list = new ArrayList<>();

        //5、把ResultSet结果集中的数据封装到一个JavaBean对象中，并且存到list中
        while (rs.next()){//循环一次，代表一行，一行就是一个JavaBean对象

            //(2)创建一个JavaBean对象
            T obj = clazz.newInstance();

            //有几列，就代表有几个属性
            //为obj的每一个属性赋值
            for (int i = 0; i < count; i++) {
                //通过反射设置属性
                //(3)从结果集的元数据对象中获取第几列的字段名
                String columnLabel = rsm.getColumnLabel(i + 1);//mysql的序号从1开始

                //(4)获取属性对象
                Field field = clazz.getDeclaredField(columnLabel);//根据字段名，获取属性对象

                //(5)设置属性可以被访问
                field.setAccessible(true);

                //(6)设置属性的值
                field.set(obj, rs.getObject(i+1));
            }

            list.add(obj);
        }

        //6、关闭
        pst.close();
        JDBCUtils.free();

        //返回结果
        return list;
    }
}
