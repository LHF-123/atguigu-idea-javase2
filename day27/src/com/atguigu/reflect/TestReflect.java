package com.atguigu.reflect;

/*
 *  Java是强类型语言，静态语言。
 *
 *  反射：在运行时可以获取类的信息，对类进行操作，而且该类可能是在编译时完全未知的类型。使得Java语言具有动态语言的特征。
 *      原来从类 --> 对象
 *      现在从这个类的Class对象 --> 操作类的所有的...
 *
 *  人为的给大家取个新名称，叫正射
 *  我们之前写代码的方式就是正射。
 *  步骤：
 *  （1）先写类
 *  （2）通过类创建对象
 *  （3）通过对象操作...
 *
 *  反射：有很多种
 *  其中一种，例如：tomcat，hibernate，spring，mybatis等各种框架
 *  （1）先创建对象             -->框架
 *  （2）通过对象操作...        -->框架
 *  （3）再写类                 -->我们写，然后通过xml等文件告知框架我的类名是什么
 *
 *  第二种：
 *  （1）先写类
 *  （2）通过4种方式之前，获取到该类的Class对象
 *  （3）用Class对象创建，这个类的对象
 *  （4）再通过Class对象操作...
 *
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//      AtGuiGuStudent stu = new AtGuiGuStudent();

        //（2）通过4种方式之前，获取到该类的Class对象
        Class<?> clazz = Class.forName("com.atguigu.day27.AtGuiGuStudent");

        //用Class对象创建，这个类AtGuiGuStudent的对象
        //因为clazz就是AtGuiGuStudent类型
        Object obj = clazz.newInstance();

        System.out.println(obj);
    }
}
