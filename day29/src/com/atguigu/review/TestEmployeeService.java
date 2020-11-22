package com.atguigu.review;

import org.junit.Test;

import java.util.Optional;

/**
 * @author LHF
 * @create 2020-09-01-11:02
 */
public class TestEmployeeService {
    @Test
    public void test1(){
        //查询编号为3的员工，打印他的名字
        EmployeeService es = new EmployeeService();
        Employee emp = es.getById(3);
        System.out.println(emp.getName());
    }

    @Test
    public void test2(){
        //查询编号为3的员工，打印他的名字
        EmployeeService es = new EmployeeService();
        Optional<Employee> opt = es.getByIdOpt(3);

        Employee emp = opt.orElse(new Employee());
        System.out.println(emp.getName());
    }

    //查询编号为2的员工，如果他的薪资<10000，就涨薪到10000
    @Test
    public void test3(){
        EmployeeService es = new EmployeeService();
        Optional<Employee> opt = es.getByIdOpt(2);

        /*
         * 映射xx操作到容器中的元素上面
         *
         *  <U> Optional<U> map(Function<? super T,? extends U> mapper)
         *  Function<T,U>：功能型函数式接口 U apply(T t)
         */
        opt.map(t -> {
            if (t.getSalary() < 10000){
                t.setSalary(10000);
            }
            return t;
        });

        Employee employee = opt.get();
        System.out.println(employee);
    }

    //查询编号为2的员工，如果他的薪资<10000，就涨薪到10000
    @Test
    public void test4(){
        EmployeeService es = new EmployeeService();
        Optional<Employee> opt = es.getByIdOpt(2);

        /*
         * Optional<T> filter(Predicate<? super T> predicate)
         * Predicate <T>: boolean test(T t)
         */
        opt = opt.filter(t -> t.getSalary() < 10000);

        if (opt.isPresent()) {
            Employee emp = opt.map(t -> {
                t.setSalary(10000);
                return t;
            }).get();
            System.out.println(emp);
        }
    }
}
