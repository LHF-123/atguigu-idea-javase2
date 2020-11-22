package com.atguigu.lambda;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/*
 *  函数式接口：所谓的SAM接口就是Single Abstract Method，即该接口中只有一个抽象方法需要实现，当然该接口可说包含其他非抽象男方法。
 *  回忆：
 *  java.lang.Runnable:public void run()
 *  java.lang.Comparable<T>:public int compareTo(T t)
 *  java.util.Comparator<T>:public int compare(T t1, T t2)
 *  java.lang.Iterable:public Iterator iterator()
 *  java.lang.reflect.InvocationHandler:public Object invoke(Object proxy, Method method, Object[] args)
 *  java.io.FileFilter:public boolean accept(File pathname)
 *  ...
 *  如上接口中有@FunctionalInterface的：Runnable，Comparator，FileFilter
 *
 *  按理说只要符合SAM特征的接口都是函数式接口，但是为了强化这个接口就是函数式接口。
 *  JDK 1.8建议，把这样的接口加一个注解标记@FunctionalInterface
 *
 *  如果没有加@FunctionalInterface注解标记的接口，表示将来可能会增加第二个抽象方法，可能会变成非SAM接口，建议这样的接口，谨慎使用Lambda表达式
 *  建议只给标记了@FunctionalInterface注解的接口使用Lambda表达式
 *
 *  如果你自己定义接口，想要表明这个接口是函数式接口，那么也可以加@FunctionalInterface注解
 *
 *  JDK 1.8增加了很多包，其中一个包java.util.function
 *  Functional interfaces provide target types for lambda expressions and method references.
 *  函数式接口是Lambda表达式和方法引用的目标类型
 *
 *  主要分为四大类：
 *  1、消费型接口（Consumer）
 *      这类接口的特点是，他的抽象方法：有参无返回值
 *  2、供给型接口（Supplier）
 *      这类接口的特点是，他的抽象方法：无参有返回值
 *  3、判断型接口（Predicate）
 *      这类接口的特点是，他的抽象方法：boolean test(有参) 无论你给我什么参数，都是用来判断条件，结果只有true和false
 *  4、功能型接口（Function）
 *      这类接口的特点是，他的抽象方法：有参有返回值
 *
 *  在java.util.function包中提供了以后开发能够遇到的所有函数式接口的类型，对于抽象方法是“无参无返回值”的情况，因为他使用情况很少，所以没有提供，如果需要就自己声明
 *  其他接口，基本不需要你自己声明，直接用它这里提供的就可以了。
 *
 */
public class TestFunctionalInterface {

    /*
     * java.io.File类
     *      File[] listFiles(FileFilter filter)
     */
    @Test
    public void test1(){
        File dir = new File("E:/资料/Java SE/day19_全天资料/资料/笔记");

        File[] listFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                //只留下文件是以.docx结尾的
                if (pathname.getName().endsWith(".docx")){
                    return true;
                }
                return false;
            }
        });

        for (File listFile : listFiles) {
            System.out.println(listFile);
        }

    }

}
@FunctionalInterface
interface MyInterface{
    void test();//有且仅有一个抽象方法
}