package com.atguigu.loader;

import org.junit.Test;

/*
 *  类的加载必须由类加载器（java.lang.ClassLoader）来完成。
 *
 *  1、类加载器对象是负责加载类的对象
 *  2、每个Class对象都包含一个对定义他的ClassLoader的引用
 *      通过Class对象可以得到加载他的类加载对象
 *
 *  不同的类是由不同的类加载器来完成的。
 *
 *  类加载器分为4大类：
 *  1、引导类加载器（Bootstrap ClassLoader）：又称为根类加载器
 *      他负责加载Java的核心库
 *      他用原生代码(C/C++)来实现的，并不继承自java.lang.ClassLoader，所以Java代码获取引导类加载器对象将会得到null
 *
 *  2、扩展类加载器（Extension ClassLoader）
 *      JDK路径/jre/lib/ext/*.jar
 *
 *  3、应用程序类加载器（Application ClassLoader）
 *       classpath下，就是自定义类型
 *
 *  4、自定义类加载器
 *  例如：tomcat
 *
 *  什么情形下自定义类加载器？
 *  （1）字节码需要加密和解密
 *  （2）加载特定目录下的类
 *
 *  关系：4，3，2，1  4认3为parent加载器，但不是继承关系
 *
 *  Java的类加载的过程是一个双亲（parent）委托模式加载的：
 *   当“应用程序类加载器”接到一个加载任务时：
 *  （1）先搜索内存中是否已经加载过了，如果加载过了，就可以找到对应的Class对象，那么就不加载了。
 *  （2）如果没有找到，把这个任务先提交给“parent”，父加载器接到任务时，也是重复（1）（2）
 *  （3）直到传给了根加载器，如果根加载器可以加载，就完成了，如果不能加载，往回传，依次每个加载器尝试在自己负责
 *      的路径下搜索，如果找到就直接返回Class对象，如果一直传到“应用程序类加载器”，还是没有找到，
 *      就会报ClassNotFoundException。
 *
 *  为什么？
 *  目的是为了安全，防止你写一个和核心类库一样的类。
 *  每一个加载器只负责自己路下的东西。
 *
 *
 */
public class ClassLoader1 {

    @Test
    public void test4(){
        //1、获取Class对象
        Class<?> c = ClassLoader1.class;

        //2、获取ClassLoader的对象
        ClassLoader loader = c.getClassLoader();
        System.out.println(loader);

        ClassLoader parent = loader.getParent();
        System.out.println(parent);

        ClassLoader grand = parent.getParent();
        System.out.println(grand);
    }

    @Test
    public void test3() throws ClassNotFoundException {
        //加载com.atguigu.day27.AtGuiGuStudent
        Class<?> c = Class.forName("com.atguigu.day27.AtGuiGuStudent");

        //获取类加载器的对象
        ClassLoader loader = c.getClassLoader();
        System.out.println(loader);
    }

    @Test
    public void test2(){
        //String是核心类，看它的类加载器对象
        Class<?> c = String.class;
        ClassLoader loader = c.getClassLoader();
        System.out.println(loader);
    }

    @Test
    public void test1(){
        //1、获取Class对象
        Class<?> c = ClassLoader1.class;

        //2、获取ClassLoader的对象
        ClassLoader loader = c.getClassLoader();
        System.out.println(loader);
    }

}
