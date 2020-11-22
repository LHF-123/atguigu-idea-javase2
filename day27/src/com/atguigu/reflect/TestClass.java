package com.atguigu.reflect;

/*
 *  从继承角度来说：
 *  Object是Class的父类
 *
 *  从内存角度来说：
 *  所有的类型都用Class对象表示。
 */
public class TestClass {
    public static void main(String[] args) {
        //Class被加载到内存后，也是用一个Class对象表示
        Class<?> clazz = Class.class;

        //Class的父类是Object
        Class<?> parent = clazz.getSuperclass();
        System.out.println(parent);

        //Object类型被加载后，又用Class对象表示
        Class<?> c1 = Object.class;
    }
}
