package com.atguigu.lambdaexer;

import org.junit.Test;

import java.util.ArrayList;

/*
 * 5、声明一个Book图书类，有编号，书名，作者，价格
 *    声明一个BookService管理类，藜麦用一个集合ArrayList<Book>来存储几本书，
 *    例如《红楼梦》《三国演义》《西游记》《从入门到精通》
 *    现在要求在BookService管理类中声明一个方法，可以查询图书
 *      public ArrayList<Book> query(Predicate<Book> p){
 *      }
 *
 *  当我调用BookService管理类的query方法时，可以实现：
 *  （1）查询指定id的书
 *  （2）查询某个作者的书
 *  （3）查询某个价格范围的书
 *  （4）查询书名包含某个字的书
 *  （5）查询所有图书
 *  ....
 */
public class TestExer5 {

    @Test
    public void test1(){
        //(1)查询指定id的书
        BookService bs = new BookService();

        /*
         *  query方法的形参：Predicate接口，抽象方法boolean test(T t)
         *  lambda表达式的形参列表(T t)
         *  lambda体，是一个条件
         */
        ArrayList<Book> query = bs.query(t -> t.getId() == 2);
        query.forEach(t -> System.out.println(t));
    }

    @Test
    public void test2(){
        //(2)查询某个作者的书
        BookService bs = new BookService();

        ArrayList<Book> query = bs.query(t -> "柴老师".equals(t.getAuthor()));
//        query.forEach(t -> System.out.println(t));
        query.forEach(System.out::println);//方法引用
    }

    @Test
    public void test3(){
        //(2)查询所有图书
        BookService bs = new BookService();

        ArrayList<Book> query = bs.query(t -> true);
//        query.forEach(t -> System.out.println(t));
        query.forEach(System.out::println);//方法引用
    }

}
