package com.atguigu.review;

import org.junit.Test;

import java.util.Optional;

/*
 * 一、
 *  JDK 1.8增加了一个java.util.Optional
 *  Optional可以看出是一个迷你型的容器，用来装一个对象的容器。
 *  因为Java语言有一个异常经常被诟病，NullPointerException。
 *
 *  从JDK 1.8之后，开始加以，当一个方法设计形参时，或者返回结果时，这个类型都可以选择Optional。
 *
 *  二、
 *  Optional类的使用
 *  1、如何创建一个Optional类？
 *  （1）static <T> Optional<T> empty()：创建一个空的Optional类的对象，相当于里面包装了一个null
 *      以前方法中return null;现在很多方法就return Optional.empty();代替
 *  （2）static <T> Optional<T> of(T value)：创建一个非空的Optional类的对象
 *  （3）static <T> Optional<T> ofNullable(T value)：创建一个可能为空也可能非空的Optional类的对象
 *
 *  2、如何取出Optional容器中的值？
 *  （1）T get()  对应of方法
 *  （2）T orElse(T other)   对应ofNullable方法
 *      如果容器中非空，那么就返回容器中的对象，如果容器中是空的，就用other来代替
 *  （3）T orElseGet(Supplier<? extends T> other)     对应ofNullable方法
 *  （4）<X extends Throwable> T orElseThrow(Supplier<? extends X> exceptioSupplier)
 *      如果容器中非空，那么就返回容器中的对象，如果容器中是空的，就抛出你指定的一次exceptionSupplier
 *
 *  3、其它方法
 *  （1）Optional<T> filter(Predicate<? super T> predicate)
 *  （2）<U> Optional<U> map(Function<? super T,? extends U> mapper)
 *  （3）boolean isPresent()
 *  （4）void ifPresent(Consumer<? super T> consumer)
 *
 */
public class TestOptional {

    @Test
    public void test7() {
        Optional<String> of = Optional.ofNullable("beijing");
        /*
         * Supplier<T>:T get()
         * 如果容器中非空，就会返回容器中的对象
         * 如果容器中是空的，就抛出Supplier提供的异常
         */
        String address = of.orElseThrow(() -> new RuntimeException("用户没有填写收货地址"));
        System.out.println(address);
    }

    @Test
    public void test6() {
        Optional<String> of = Optional.ofNullable("beijing");
        /*
         * Supplier<T>:T get()
         * 如果容器中非空，就会返回容器中的对象
         * 如果容器中是空的，就用Supplier这个供给型接口提供的对象来代替
         */
        String address = of.orElseGet(() -> new String("shanghai"));
        System.out.println(address);
    }

    @Test
    public void test5() {
//        Optional<String> of = Optional.ofNullable(null);
        Optional<String> of = Optional.ofNullable("beijing");
        String address = of.orElse("shanghai");
        System.out.println(address);
    }

    @Test
    public void test4() {
        Optional<String> of = Optional.of("beijing");
        String address = of.get();
        System.out.println(address);//beijing
    }

    @Test
    public void test3() {
//        Optional<String> of = Optional.of(null);//必须非空
//        System.out.println(of);
    }

    @Test
    public void test2() {
        Optional<String> of = Optional.of("beijing");
        System.out.println(of);//beijing
    }

    @Test
    public void test1() {
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);//Optional.empty
    }

}
