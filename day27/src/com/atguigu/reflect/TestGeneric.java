package com.atguigu.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
 *  获取某个类型的泛型父类信息
 *
 *  Type:
 *   Type是Java编程语言中所有类型的公共高级接口
 *      他们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
 *
 *      参数化类：ArrayList<String>      --> ParameterizedType
 *      类型变量：T, E, K, V
 *
 */
public class TestGeneric {
    public static void main(String[] args) {
        //获取Son的泛型父类：Father<String, Integer>
        //(1)Son的Class对象
        Class<?> clazz = Son.class;

        //(2)获取父类，没有泛型
//        Class parent = clazz.getSuperclass();
//        System.out.println(parent);

        //(2)获取泛型父类
        Type type = clazz.getGenericSuperclass();

        //因为Father<String, Integer>是参数化类型
        ParameterizedType p = (ParameterizedType) type;

        //(3)获取泛型实参<String, Integer>
        Type[] types = p.getActualTypeArguments();
        for (Type t : types) {
            System.out.println(t);
        }

    }
}
abstract class Father<T, U>{

}
class Son extends Father<String, Integer>{

}