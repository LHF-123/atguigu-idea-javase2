package com.atguigu.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

/*
 *  三、在运行期间，动态的为对象的属性赋值或获取属性值
 *  步骤：
 *  1、获取Class对象
 *  2、创建实例对象
 *  3、创建实例对象，Class代表的类型的实例对象，例如这里是学生对象
 *  4、调用Field对象.set(实例对象， 属性值)
 *      调用Field对象.get(实例对象)
 *
 *  说明：如果属性是私有的，那么可以调用
 *      Field对象.setAccessible(true);
 *
 */
public class TestFieldSetGet {

    @Test
    public void test1() throws Exception {
        //1、获取Class对象
        Class<?> clazz = Class.forName("com.atguigu.day27.AtGuiGuStudent");

        //2、获取Field属性对象
        //例如：这里要为name属性赋值
        Field nameField = clazz.getDeclaredField("name");

        //3、创建AtGuiGuStudent的对象
        Object stu = clazz.newInstance();

        nameField.setAccessible(true);//设置nameField为可访问的

        //4、为属性赋值
        nameField.set(stu, "张三");//相当于stu.name="张三"，而不是调用set方法。name是私有属性，无法直接赋值，见29行

        System.out.println(stu);
    }

}
