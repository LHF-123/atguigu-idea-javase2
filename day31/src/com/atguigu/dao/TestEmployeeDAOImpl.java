package com.atguigu.dao;

import com.atguigu.bean.Employee;

import java.util.ArrayList;

/**
 * @author LHF
 * @create 2020-09-05-22:28
 */
public class TestEmployeeDAOImpl {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAOImpl();
        ArrayList<Employee> all = dao.getAllEmployee();
        for (Employee employee : all) {
            System.out.println(employee);
        }
    }
}
