package com.atguigu.loader;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 *  类加载器的作用：
 *  1、最主要的作用：加载类
 *  2、辅助的作用：可以用它来加载“类路径下”的资源文件
 *      JavaSE：例如：bin中  src下文件-->bin目录下
 *
 *  ClassLoader:
 *  （1）静态方法：
 *      ClassLoader.getSystemResourceAsStream("src1.properties")
 *      但是这个方法只适用于JavaSE阶段，因为它用应用程序类加载器去加载的
 *      如果是Web阶段，用这个方法是有问题的，因为Web阶段的类路径在WEB-INF/classes下，必须由他自定义的类加载器去加载
 *
 *  （2）非静态方法
 *      类加载器对象.getResourceAsStream("src1.properties")
 *      Web阶段用（2）方法
 *
 *  Properties:
 *   Properties 类表示了一个持久的属性集。Properties 可以保存在流中或从流中加载。属性列表中每一个键及其对应值都是一个字符串
 *
 */
public class TestLoaderFile {

    @Test
    public void test5(){
        //1、创建一个Properties对象，用来装加载器建立的数据(key, value)
        Properties pro = new Properties();

        try {
            //2、要从src1.properties文件中加载
            //先获取当前类的加载器对象
            ClassLoader loader = TestLoaderFile.class.getClassLoader();

            //config是一个Source Folder，等价于src
            pro.load(loader.getResourceAsStream("other.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3、遍历显示
        System.out.println(pro);
    }

    @Test
    public void test4(){
        //1、创建一个Properties对象，用来装加载器建立的数据(key, value)
        Properties pro = new Properties();

        try {
            //2、要从src1.properties文件中加载
            //先获取当前类的加载器对象
            ClassLoader loader = TestLoaderFile.class.getClassLoader();
            pro.load(loader.getResourceAsStream("com/atguigu/loader/src2.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3、遍历显示
        System.out.println(pro);
    }

    @Test
    public void test3(){
        //1、创建一个Properties对象，用来装加载器建立的数据(key, value)
        Properties pro = new Properties();

        try {
            //2、要从src1.properties文件中加载
            //先获取当前类的加载器对象
            ClassLoader loader = TestLoaderFile.class.getClassLoader();
            pro.load(loader.getResourceAsStream("src1.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3、遍历显示
        System.out.println(pro);
    }

    @Test
    public void test2(){
        //1、创建一个Properties对象，用来装加载器建立的数据(key, value)
        Properties pro = new Properties();

        try {
            //2、要从src1.properties文件中加载
            pro.load(ClassLoader.getSystemResourceAsStream("src1.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3、遍历显示
        System.out.println(pro);
    }

    @Test
    public void test1(){
        //1、创建一个Properties对象，用来装加载器建立的数据(key, value)
        Properties pro = new Properties();

        try {
            //2、要从src1.properties文件中加载，new FileInputStream只能加载跟src同级的文件src_out.properties
            pro.load(new FileInputStream("src_out.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3、遍历显示
        System.out.println(pro);
    }

}
