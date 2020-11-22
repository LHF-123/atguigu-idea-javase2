package com.atguigu.dao;

import com.atguigu.bean.Employee;

import java.util.ArrayList;

/**
 * @author LHF
 * @create 2020-09-05-21:14
 */
public interface EmployeeDAO {
    void addEmployee(Employee emp);
    ArrayList<Employee> getAllEmployee();
    void update(Employee emp);
    void deleteByEid(int eid);
}
