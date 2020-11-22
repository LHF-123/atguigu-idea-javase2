package com.atguigu.dao;

import com.atguigu.bean.Department;

import java.util.ArrayList;

/**
 * @author LHF
 * @create 2020-09-05-21:10
 */
public interface DepartmentDAO {
    void add(Department department);
    ArrayList<Department> getAll();
    void update(Department department);
    void deleteByDid(int did);
}
