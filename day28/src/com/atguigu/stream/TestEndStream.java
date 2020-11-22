package com.atguigu.stream;

import com.atguigu.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 三、终结操作
 *  一个流一旦终结就结束了，就不能用了，需要重写创建新的Stream
 *
 *  1、forEach(Consumer c)
 *  2、long count()
 *  3、Optional<T> max(Comparator c)
 *      Optional<T> min(Comparator  c)
 *  4、boolean allMatch(Predicate p):所有的都匹配
 *      boolean anyMatch(Predicate p):有任意一个匹配
 *      boolean noneMatch(Predicate p):都不匹配
 *  5、R collect(Collector c)
 *      Collectors 工具类提供了很多静态方法，可以方便的创建常用的收集器实例。
 */
public class TestEndStream {

    @Test
    public void test3(){
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "张三", 10000));
        list.add(new Employee(2, "李四", 8000));
        list.add(new Employee(3, "王五", 6000));

        //找出里面所有的薪资低于10000的员工，构成一个新的集合
        List<Employee> collect = list.stream()
                .filter(t -> t.getSalary() < 10000)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

    }

    @Test
    public void test2(){
        boolean b = Stream.of(2, 5, 1, 7, 9).allMatch(t -> t % 2 != 0);
        System.out.println(b);
    }

    @Test
    public void test1(){
        Optional<Integer> max = Stream.of(2,5,1,7,9).max(Integer::compare);
        System.out.println(max);
    }

}
