package com.atguigu.stream;

import com.atguigu.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
 * 二、中间操作
 *  1、filter(Predicate p)：过滤保留为p为true的
 *  2、distinct()：去重
 *  3、limit(long maxSize)：取流中的前maxSize个
 *  4、skip(long n)：跳过前n个
 *  5、peek(Consumer action)：对流中的元素，挨个执行consumer接口的action操作
 *  6、sorted()
 *      sorted(Comparator com)
 *  7、map(Function f):对流中的每一个元素，都映射f指定的操作
 *  8、flatMap(Function f)
 */
public class TestMiddleStream {

    @Test
    public void test11(){
        Stream.of("hello,world,java", "张三,李四,王五")
                //<R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
                .flatMap(t -> Stream.of(t.split(",")))//Function<T,R> 要求这个R的类型是一个Stream类型
                .forEach(System.out::println);//结果发现，流中是两个数组
    }

    @Test
    public void test10(){
        Stream.of("hello,world,java", "张三，李四，王五")
                .map(t -> t.split(","))//Function: R apply(T t)
                .forEach(System.out::println);//结果发现，流中是两个数组
    }

    @Test
    public void test9(){
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                /*
                 * Function: R apply(T t)
                 */
                .map(t -> t * 10)   //每一个元素都变成他原来的10倍
                .forEach(System.out::println);
    }

    @Test
    public void test8(){
        Stream.of(3,1,2,4,6,5,7,9,8,10)
                .sorted((t1, t2) -> -Integer.compare(t1, t2))
                .forEach(System.out::println);
    }

    @Test
    public void test7(){
        Stream.of(3,1,2,4,6,5,7,9,8,10).sorted().forEach(System.out::println);
    }

    @Test
    public void test6(){
        long count = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(t -> t % 2 == 0)
                .peek(t -> System.out.println(t)) //Consumer消费型接口
                .count();

        System.out.println(count);
    }

    @Test
    public void test5(){
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void test4(){
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .skip(3)
                .forEach(System.out::println);
    }

    @Test
    public void test3(){
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "张三", 10000));
        list.add(new Employee(1, "张三", 10000));
        list.add(new Employee(2, "李四", 8000));
        list.add(new Employee(3, "王五", 6000));

        list.stream()           //1、创建Stream对象
                .filter(t -> t.getSalary() >= 10000)//2、先去掉薪资低于10000的
                .distinct()                     //然后去重
                .forEach(System.out::println);      //遍历
    }

    @Test
    public void test2(){
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "张三", 10000));
        list.add(new Employee(1, "张三", 10000));

        //1、创建Stream对象
        Stream<Employee> stream = list.stream();

        //2、distinct去重
        stream = stream.distinct();//需要重写hashCode和equals方法

        //终结操作
        stream.forEach(System.out::println);
    }

    @Test
    public void test1(){
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "张三", 10000));
        list.add(new Employee(1, "张三", 10000));

        //1、创建Stream对象
        Stream<Employee> stream = list.stream();

        //2、过滤掉名字为“张三”的
        //Predicate：判断型接口 boolean test(T t)
        stream = stream.filter(t -> !"张三".equals(t.getName()));

        //终结操作
        stream.forEach(System.out::println);
    }

}
