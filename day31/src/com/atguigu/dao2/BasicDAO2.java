package com.atguigu.dao2;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @author LHF
 * @create 2020-09-05-22:36
 *
 * apache工具包，有一个ResultSetHandler接口，结果集处理器的接口
 * ResultSetHandler接口的实现类们：
 * （1）BeanListHandler：结果是一个List<T>
 * （2）BeanHandler：结果是一个JavaBean对象
 * （3）MapHandler：结果是一行多列，但是又不是JavaBean对象
 * （4）MapListHandler：结果是多行多列，但是又不是JavaBean对象
 * （5）ScalarHandler<T>：单个值的封装类型
 */
public class BasicDAO2 {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDs());

    //适用于insert,update,delete语句
    public int update(String sql, Object... param) throws Exception {
        return qr.update(sql, param);
    }

    public int update(Connection conn, String sql, Object... param) throws Exception {
        return qr.update(conn,sql, param);
    }

    //查询多个JavaBean
    public <T> List<T> getAll(Class<T> clazz, String sql, Object... param) throws Exception{
        return qr.query(sql, new BeanListHandler<T>(clazz), param);
    }

    //查询一个JavaBean，一般跟着主键，唯一键
    public <T> T getById(Class<T> clazz, String sql, Object... param) throws Exception{
        return qr.query(sql, new BeanHandler<T>(clazz), param);
    }

    //例如：查询总记录数，最高工资，最低工资，平均工资...单个值
    public Object queryObject(String sql, Object... param) throws Exception{
        return qr.query(sql, new ScalarHandler<>(), param);
    }

    //按部门查询平均工资
    public List<Map<String, Object>> queryMap(String sql, Object... param) throws Exception{
        return qr.query(sql, new MapListHandler(), param);
    }
}
