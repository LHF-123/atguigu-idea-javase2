package com.atguigu.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/*
 * java.util.stream.Stream
 *
 * 一、创建Stream
 *  1、用数组创建
 *
 *  数组工具类：java.util.Arrays
 *      static <T> Stream<T> stream(T[] array)
 *
 * 2、用集合创建
 *      集合对象.stream()
 *
 * 3、用Stream中的of方法
 *      Stream.of(T...values)
 *
 * 4、无限流
 *  Stream类这
 *      static <T> Stream<T> generate(Supplier<T> s)
 *      static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
 *
 *  UnaryOperator<T>：是一个函数式接口，extends Function<T, R>
        T apply(T t)
 */
public class TestCreateStream {

    @Test
    public void test5(){
        //t是流中的数据，第一个数据是1，种子
        //在1的基础上+2，并且不断迭代
        //数据流中的数据 1,3,5,7,9....
        Stream<Integer> iterate = Stream.iterate(1, t -> t + 2);

        //为了看效果，加一步中间操作
        iterate = iterate.limit(100);//必须接受，不接受就有问题

        iterate.forEach(System.out::println);
    }

    @Test
    public void test4(){
        //用Math.random()来产生随机值
//        Stream<Double> generate = Stream.generate(() -> Math.random());
        Stream<Double> generate = Stream.generate(Math::random);

        generate.forEach(System.out::println);
    }

    @Test
    public void test3(){
        Stream<String> stream = Stream.of("hello", "world", "java");
    }

    @Test
    public void test2(){
        ArrayList<String> list = new ArrayList<>();

        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("hello");

        Stream<String> stream = list.stream();
    }

    @Test
    public void test1(){
        String[] arr = {"hello", "world", "java"};

        Stream<String> stream = Arrays.stream(arr);

        //例如，提取用一下终结操作
//        stream.forEach(t -> System.out.println(t));
        stream.forEach(System.out::println);
    }
}
