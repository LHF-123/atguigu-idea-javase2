package com.atguigu.dao;

import com.atguigu.bean.Employee;

import java.util.ArrayList;

/**
 * @author LHF
 * @create 2020-09-05-22:18
 */
public class EmployeeDAOImpl extends BasicDao implements EmployeeDAO{
    @Override
    public void addEmployee(Employee emp) {
        try {
            String sql = "INSERT INTO t_employee VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            update(sql,emp.getEname(),
                    emp.getTel(),
                    emp.getGender(),
                    emp.getSalary(),
                    emp.getCommissionPct(),
                    emp.getBirthday(),
                    emp.getHiredate(),
                    emp.getJobId(),
                    emp.getEmail(),
                    emp.getMid(),
                    emp.getAddress(),
                    emp.getNativePlace(),
                    emp.getDid());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Employee> getAllEmployee() {
        try {
            String sql = "SELECT eid, ename,tel,gender,salary,commission_pct as commissionPct, birthday, hiredate, job_id as jobId, email,mid, address, native_place as nativePlace,did FROM t_employee;";
            ArrayList<Employee> all = getAll(Employee.class, sql);
            return all;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Employee emp) {

    }

    @Override
    public void deleteByEid(int eid) {

    }
}
