package com.atguigu.lambdaexer;

import org.junit.Test;

import java.util.TreeSet;

/*
 *  3、EnglishStudent 类型：学号，姓名（用英文名），成绩，默认排序是按照学号排序
 *  （1）使用TreeSet保存本组学员的对象（EnglishStudent），用forEach(Consumer c)方法遍历
 *  （2）使用TreeSet(Comparator)保存本组学员的对象（EnglishStudent）
 *  要求按照姓名排序。不区分大小写，再用forEach(Consumer c)方法遍历
 */
public class TestExer3 {

    @Test
    public void test3(){
        //Comparator<T>:int compara(T t1, T t2)
        //TreeSet不可重复的依据，不是hashCode和equals，而是看比较大小的方法，他会认为“大小相等”就是相同元素
        //成绩相同，再按学号排序
        TreeSet<EnglishStudent> set = new TreeSet<>((t1, t2) -> t1.getScore()==t2.getScore()?t1.getId()-t2.getId(): t1.getScore()-t2.getScore());

        set.add(new EnglishStudent(1, "Jack", 89));
        set.add(new EnglishStudent(2, "Shangkun", 96));
        set.add(new EnglishStudent(3, "Anne", 96));

        //Consumer: void xxx(T t)
        set.forEach(t -> System.out.println(t));

    }

    @Test
    public void test2(){
        //Comparator<T>:int compara(T t1, T t2)
        TreeSet<EnglishStudent> set = new TreeSet<>((t1, t2) -> t1.getName().compareToIgnoreCase(t2.getName()));

        set.add(new EnglishStudent(1, "Jack", 89));
        set.add(new EnglishStudent(2, "Shangkun", 96));
        set.add(new EnglishStudent(3, "Anne", 96));

        //Consumer: void xxx(T t)
        set.forEach(t -> System.out.println(t));

    }

    @Test
    public void test(){
        TreeSet<EnglishStudent> set = new TreeSet<>();

        set.add(new EnglishStudent(1, "Jack", 89));
        set.add(new EnglishStudent(2, "Shangkun", 59));
        set.add(new EnglishStudent(3, "Anne", 96));

        //Consumer: void xxx(T t)
        set.forEach(t -> System.out.println(t));

    }
}
