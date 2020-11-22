package com.atguigu.lambdaexer;

import java.util.ArrayList;

/**
 * @author LHF
 * @create 2020-08-30-12:27
 *
 * 练习2：使用removeIf(Predicate p)方法删除元素
 *      创建一个ArrayList集合，保存本组学员的对象（Student）
 *      删除成绩不及格的学员
 *
 * Student类型：学号、姓名、成绩
 */
public class TestExer2 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(1, "尚坤", 19));
        list.add(new Student(2, "张三", 61));
        list.add(new Student(3, "李四", 89));

        //Predicate 判断型接口 boolean xxx(T t)
        //Lambda表达式的形参列表：(T t)，省略后t
        //Lambda体，就一个判断条件，这个判断为真 true，删除
        list.removeIf(t -> t.getScore()<60);

        list.forEach(t -> System.out.println(t));
    }
}
