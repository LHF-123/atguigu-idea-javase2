package com.atguigu.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/*
 *  二、在运行期间，动态的创建任意类型的对象，只要这个类型可以创建对象
 *  1、Class对象，newInstance
 *      前提：这个类型必须有无参构造
 *      步骤：
 *      （1）获取Class对象
 *      （2）直接调用Class对象.newInstance()
 *
 *  2、构造器来创建对象
 *      步骤：
 *      （1）获取Class对象
 *      （2）获取构造器对象，获取其中一个
 *          Class类中有这样的方法：
 *          Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
 *                  parameterTypes：构造器形参的类型列表
 *
 *  构造器可以重载，有很多个，如何确定要哪一个？
 *      通过形参列表
 *
 *  （3）用构造器创建对象
 *      java.lang.reflect.Constructor类型中：
 *          T newInstance(Object...initargs)
 *              initargs:创建对象时，给构造器的实参列表
 *
 */
public class TestNewInstance {

    @Test
    public void test2() throws Exception {
        //1、获取Class对象
        Class<?> clazz = Class.forName("com.atguigu.day27.AtGuiGuStudent");

        //2、获取构造器对象
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        //constructor代表 public AtGuiGuStudent(String name){}构造器

        //3、用构造器创建对象
        Object obj = constructor.newInstance("张三");//new AtGuiGuStudent("张三")
        System.out.println(obj);
    }

    @Test
    public void test1() throws Exception {
        //1、获取Class对象
        Class<?> clazz = Class.forName("com.atguigu.day27.AtGuiGuStudent");

        //2、创建AtGuiGuStudent的对象
        //clazz代表类型，虽然它本身是Class对象，但是他是代表类型
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }

}
