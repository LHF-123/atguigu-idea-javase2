package com.atguigu.lambdaexer;

import java.util.HashMap;

/*
 * 4、创建一个HashMap，key是你的姓名，value是你女朋友（男朋友）的姓名
 *  使用Map的default void forEach(BiConsumer<? super K, ? super V> action)这个方法遍历显示Map
 */
public class TestExer4 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("张三", "如花");
        map.put("李四", "翠花");

        /*
         * BiConsumer<? super K, ? super V>也是一个消费型接口， void accept(T t, U u)
         * Lambda表达式的形参列表：(T t, U u)
         * Lambda体，打印键值对
         */
        map.forEach((k, v) -> System.out.println("我是" + k + "，我的（男）女朋友是：" + v));
    }
}
