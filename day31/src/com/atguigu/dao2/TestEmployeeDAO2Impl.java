package com.atguigu.dao2;

import com.atguigu.bean.Employee;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author LHF
 * @create 2020-09-06-9:33
 */
public class TestEmployeeDAO2Impl {
    EmployeeDAO2Impl dao = new EmployeeDAO2Impl();

    @Test
    public void test1(){
        Employee emp = dao.getById(2);
        System.out.println(emp);
    }

    @Test
    public void test2(){
        long count = dao.count();
        System.out.println(count);
    }

    @Test
    public void test3(){
        List<Map<String, Object>> query = dao.query();
        for (Map<String, Object> map : query) {
            Set<Map.Entry<String, Object>> entrySet = map.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                System.out.println(entry);
            }
        }
    }
}
