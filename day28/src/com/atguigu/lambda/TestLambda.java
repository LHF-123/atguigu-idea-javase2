package com.atguigu.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/*
 *  JDK 1.8:2014年，自Java 5以来最具革命性的版本
 *
 *  一、Lambda表达式
 *  引入函数式编程风格。
 *
 *  以前调用Java的方法时，实参必须是一个基本数据类型或者是一个对象
 *  现在可以给一些引用数据类型的形参，传“一段代码”，而不是“一个对象”。这段代码是一个函数（方法）的方法体。
 *
 *  Lambda写得好可以极大的减少代码冗余，同时可读性也好过冗长的匿名内部类。
 *      --> 不是所有的引用数据类型都可以使用Lambda表达式，只有少部分可以使用。
 *
 *  SAM接口（函数式接口）类型的形参，变量才可以赋值为Lambda表达式。
 *
 *  函数式接口：SAM（Single Abstract Method）只有一个抽象方法的接口。当然这个接口可以有默认方法和静态方法成员
 *
 *  结论：
 *  （1）只有函数式接口才能用Lambda表达式
 *  （2）Lambda作用就是简化代码，使得代码更整洁。
 *
 */
public class TestLambda {

    @Test
    public void test4() {
        //存到TreeSet中的元素要么实现java.lang.Comparable接口
        //要么给TreeSet传一个java.util.Comparator接口的比较器对象
        TreeSet<Employee> set = new TreeSet<>(((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary())));

        set.add(new Employee(1, "张三", 10000));
        set.add(new Employee(2, "李四", 8000));

        for (Employee employee : set) {
            System.out.println(employee);
        }
    }

    @Test
    public void test3() {
        //存到TreeSet中的元素要么实现java.lang.Comparable接口
        //要么给TreeSet传一个java.util.Comparator接口的比较器对象
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });

        set.add(new Employee(1, "张三", 10000));
        set.add(new Employee(2, "李四", 8000));

        for (Employee employee : set) {
            System.out.println(employee);
        }
    }

    @Test
    public void test2() {
        //创建多线程的两种方式，其中一种实现Runnable接口
        //Runnable的抽象方法：public void run()
        new Thread(() -> System.out.println("hello")).start();
    }

    @Test
    public void test1() {
        //创建多线程的两种方式，其中一种实现Runnable接口
        //Runnable的抽象方法：public void run()
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();
    }

}
