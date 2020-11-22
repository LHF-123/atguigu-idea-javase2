package com.atguigu.dao2;


import com.atguigu.bean.Employee;

import java.util.List;
import java.util.Map;

/**
 * @author LHF
 * @create 2020-09-05-22:18
 */
public class EmployeeDAO2Impl extends BasicDAO2 implements EmployeeDAO2 {

    @Override
    public Employee getById(int eid) {
        try {
            String sql = "SELECT eid, ename,tel,gender,salary,commission_pct as commissionPct, birthday, hiredate, job_id as jobId, email,mid, address, native_place as nativePlace,did FROM t_employee WHERE eid = ?;";
            return getById(Employee.class, sql, eid);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public long count() {
        try {
            String sql = "SELECT count(*) FROM t_employee";
            Object obj = queryObject(sql);
            return (long) obj;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Map<String, Object>> query() {
        try {
            String sql = "SELECT did, AVG(salary) FROM t_employee GROUP BY did";
            return queryMap(sql);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
