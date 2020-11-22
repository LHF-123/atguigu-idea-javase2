package com.atguigu.dao2;

import com.atguigu.bean.Employee;

import java.util.List;
import java.util.Map;

/**
 * @author LHF
 * @create 2020-09-05-21:14
 */
public interface EmployeeDAO2 {
    /*void addEmployee(Employee emp);
    ArrayList<Employee> getAllEmployee();
    void update(Employee emp);
    void deleteByEid(int eid);*/

    Employee getById(int eid);
    long count();
    List<Map<String, Object>> query();
}
