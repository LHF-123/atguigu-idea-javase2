package com.atguigu.lambdaexer;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author LHF
 * @create 2020-08-30-16:34
 * 声明一个BookService管理类，藜麦用一个集合ArrayList<Book>来存储几本书，
 *    例如《红楼梦》《三国演义》《西游记》《从入门到精通》
 *    现在要求在BookService管理类中声明一个方法，可以查询图书
 *      public ArrayList<Book> query(Predicate<Book> p){
 *      }
 */
public class BookService {
    private ArrayList<Book> list;

    public BookService() {
        //初始化一些书
        list = new ArrayList<>();

        list.add(new Book(1, "《红楼梦》", "曹雪芹", 99));
        list.add(new Book(2, "《三国演义》", "罗贯中", 100));
        list.add(new Book(3, "《水浒传》", "施耐庵", 87));
        list.add(new Book(4, "《西游记》", "吴承恩", 66));
        list.add(new Book(5, "《Java从入门到精通》", "柴老师", 28));
        list.add(new Book(6, "《Java从入门到放弃》", "柴老师", 88));
    }

    /*
     * Predicate是一个判断型接口，抽象方法 boolean test(T t)
     * 根据p接收一个Lambda表达式的条件来筛选图书
     */
    public ArrayList<Book> query(Predicate<Book> p){
        ArrayList<Book> result = new ArrayList<>();

        //遍历list集合，然后满足条件的添加到result集合中
        for (Book book : list) {
            if (p.test(book)) {//判断这个book是否满足p的条件
                result.add(book);
            }
        }

        return result;
    }
}
