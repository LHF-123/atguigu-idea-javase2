package com.atguigu.reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/*
 *  四、在运行期间，动态的调用任意对象的任意方法
 *  步骤：
 *  1、获取Class对象
 *  2、获取Method对象
 *  方法有重载，如何确定是哪个方法？方法名+形参列表
 *      clazz.getDeclaredMethod(name, parameterTypes);
 *
 *  3、创建实例对象
 */
public class TestMethodInvoke {

    @Test
    public void test2() throws Exception{//调用静态方法
        //1、获取Class对象
        Class<?> clazz = Class.forName("com.atguigu.day27.AtGuiGuStudent");

        //调用AtGuiGuStudent类的public static void test(int a)方法

        //2、获取Method对象
        Method m = clazz.getDeclaredMethod("test", int.class);

        //3、调用方法
        m.invoke(null, 10);//如果是静态方法，实例对象可以用null
    }

    @Test
    public void test1() throws Exception {
        //1、获取Class对象
        Class<?> clazz = Class.forName("com.atguigu.day27.AtGuiGuStudent");

        //2、获取Method对象
        //method代表 public void setName(String name) {}
        Method method = clazz.getDeclaredMethod("setName", String.class);

        //3、创建实例对象
        Object stu = clazz.newInstance();

        //4、调用方法
        Object invoke = method.invoke(stu, "李四");
        System.out.println(invoke);//如果method代表的方法没有返回值，那么会返回null

        System.out.println(stu);

        //调用getName
        Method m2 = clazz.getDeclaredMethod("getName");//getName没有形参
        Object value = m2.invoke(stu);

        System.out.println(value);
    }

}
