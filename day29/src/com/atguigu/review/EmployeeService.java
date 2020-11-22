package com.atguigu.review;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author LHF
 * @create 2020-09-01-10:58
 */
public class EmployeeService {
    private ArrayList<Employee> list;

    public EmployeeService() {
        //初始化集合，添加模拟数据
        list = new ArrayList<>();

        list.add(new Employee(1, "张三", 10000));
        list.add(new Employee(2, "李四", 8000));
    }

    //可以根据id查询员工对象的方法
    public Employee getById(int id){
        for (Employee employee : list) {
            if (id == employee.getId()){
                return employee;
            }
        }
        return null;
    }

    public Optional<Employee> getByIdOpt(int id){
        for (Employee employee : list) {
            if (id == employee.getId()){
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }
}
