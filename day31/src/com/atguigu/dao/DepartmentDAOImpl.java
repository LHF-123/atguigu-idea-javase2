package com.atguigu.dao;

import com.atguigu.bean.Department;

import java.util.ArrayList;

/**
 * @author LHF
 * @create 2020-09-05-21:13
 */
public class DepartmentDAOImpl extends BasicDao implements DepartmentDAO{
    @Override
    public void add(Department department) {
        try {
            String sql = "INSERT INTO t_department VALUES(NULL, ?, ?)";
            update(sql, department.getDname(), department.getDescription());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Department> getAll() {
        String  sql = "SELECT * FROM t_department";
        try {
            ArrayList<Department> all = getAll(Department.class, sql);
            return all;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void update(Department department) {
        try {
            String sql = "UPDATE t_department SET dname = ? , description = ? WHERE did = ?;";
            update(sql,department.getDname(), department.getDescription(), department.getDid());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteByDid(int did) {
        try {
            String sql = "DELETE FROM t_department WHERE did = ?;";
            update(sql, did);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
