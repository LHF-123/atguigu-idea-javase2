package com.atguigu.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 *  获取注解信息
 *
 *  注解分为三个部分：
 *  1、声明
 *  2、使用
 *  3、读取
 *      要使得注解在反射阶段被读取到，必须保证该注解可以滞留到运行时
 *
 *  反射阶段：运行时
 */
public class TestAnntation {
    public static void main(String[] args) {
        //读取Class类型上的注解
        //（1）获取MyClass的Class对象
        Class<?> clazz = MyClass.class;

        //(2)获取MyClass类型上的注解
        MyAnntation my = clazz.getAnnotation(MyAnntation.class);

        //（3）获取注解的配置参数的值
        my.value();//把value当做方法一样调用
    }
}

//使用注解
@MyAnntation("尚硅谷")//把value当做属性一样赋值
class MyClass{

}

//声明注解
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnntation {
    String value();//配置参数
}