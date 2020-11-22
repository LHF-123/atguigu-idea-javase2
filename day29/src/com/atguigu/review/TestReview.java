package com.atguigu.review;

/*
 * 一、Lambda表达式
 *  1、为什么要引入Lambda表达式
 *      目的：为了把函数式编程风格引入Java，可以简化代码。
 *  2、什么时候才能使用Lambda表达式？
 *      给“函数式接口”的形参或变量赋值时，才能使用Lambda表达式
 *  3、什么是函数式接口？
 *      SAM接口，只要一个抽象方法的接口，并且强烈建议使用@FunctionalInterface注解标记
 *  4、Lambda表达式的语法：
 *      (形参列表) -> {Lambda体}
 *
 *      (形参列表)：就是函数式接口的唯一的抽象方法的形参列表
 *      {Lambda体}：就是实现函数式接口的唯一的抽象方法的方法体。当调用这个接口的抽象方法时，就会执行你传入的{Lambda体}
 *
 *  说明：
 *  （1）当(形参列表)是空参()，那么括号不能省略
 *  （2）当(形参列表)只有一个形参时，并且类型也可以确定或推断时，可以省略()和数据类型。要省略一起省略，不能只省略类型或()
 *  （3）当(形参列表)有多个时，而且类型也可以确定或可以推断时，可以省略数据类型
 *
 *  （4）当{Lambda体}中不止一条语句时，不能省略{}，并且每一条语句还必须加;
 *  （5）当{Lambda体}中只有一条语句时，可以省略{}和该语句的;
 *  （6）当{Lambda体}中不止一条语句，并且是一个{return 返回值;}语句，那么可以一起省略return和{}和;
 *  （7）当{Lambda体}如果不止一条语句，那么如果函数式接口的抽象方法都有返回值，那么必须return
 *
 * 5、函数式接口代表：
 *  我们之前学过的接口中标记了@FunctionalInterface注解标记的接口
 *  Comparator<T>: int compara(T t1, T t2)
 *  Runnable: void run()
 *  FileFilter: boolean accept(File pathname)
 *
 *  Java8在java.util.function包中增加了43个：
 *  四个最基本的函数式接口：
 *  （1）消费型接口 Consumer<T>:void accept(T t)
 *  （2）供给型接口 Supplier<T>:T get()
 *  （3）判断型接口 Predicate<T>:boolean test(T t)
 *  （4）功能型接口 Function<T, R>: R apply(T t)
 *
 *  6、方法引用和构造器引用
 *  为了简化lambda表达式
 *  （1）什么时候使用方法引用？
 *      当{lambda体}只有一句时，并且是通过调用一个类或一个对象方法来完成的，
 *      并且函数式接口的抽象方法的形参列表和返回值类型 与 你调用的这个类或对象的方法的形参列表和返回值类型要对应
 *  （2）什么时候才能使用构造器引用？
 *      当{lambda体}只有一句时，并且是通过创建一个对象来完成的，
 *
 *  （3）方法引用和构造器引用语法
 *      类名/对象名::方法名
 *      类名/数据类型::new
 *
 *  二、Stream API
 *  1、用于处理内存中的数据
 *      像SQL语句来操作数据库一样的形式。
 *  2、Stream流的特点
 *  （1）Stream流不可变，每次改变都会创建一个新的流
 *  （2）Stream流也不会改变数据源的数据
 *  （3）Stream的中间操作是一个延迟操作，一直到终结操作时，一起完成
 *  3、Stream API的使用分为三个步骤
 *  （1）创建Stream
 *  （2）0~n步中间操作
 *  （3）终结操作
 *
 *  4、四种方式创建Stream
 *  （1）通过Arrays.stream(数组)
 *  （2）通过集合对象.stream()
 *  （3）Stream.of(...)
 *  （4）创建无限流
 *      Stream.generate(Supplier)
 *      Stream.iterate(T seed, UnaryOperator)
 *  5、中间操作:这些方法的返回值类型还是Stream，所以可以继续操作
 *  （1）filter(Predicate p)：过滤保留为p为true的
 *  （2）distinct()：去重
 *  （3）limit(long maxSize)：取流中的前maxSize个
 *  （4）skip(long n)：跳过前n个
 *  （5）peek(Consumer action)：对流中的元素，挨个执行consumer接口的action操作
 *  （6）sorted()
 *      sorted(Comparator com)
 *  （7）map(Function f):对流中的每一个元素，都映射f指定的操作
 *  （8）flatMap(Function f)
 *  6、终结操作:这些方法的返回值类型不是Stream，所以不能继续操作，所以对Stream的操作就结束了
 *  （1）forEach
 *  （2）count
 *  （3）max
 *  （4）min
 *  （5）allMatch
 *      anyMatch
 *      noneMatch
 *  （6）collect
 */
public class TestReview {
    public static void main(String[] args) {

    }
}
