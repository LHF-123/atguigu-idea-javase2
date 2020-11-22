package com.atguigu.lambda;

import org.junit.Test;

import java.util.ArrayList;

/*
 * 三、判断型（判定型）接口
 *      抽象法法：boolean test(参数)
 *  1、基本的代表
 *      Predicate<T> boolean test(T t)
 *  2、其它的变形
 *      BiPredicate<T, U> boolean test(T t, U u)
 *      DoublePredicate boolean test(double value)
 *      IntPredicate boolean test(int value)
 *      LongPredicate boolean test(long value)
 *
 *
 *  例如：java.util.Collection<E>
 *      default boolean removeIf(Predicate<? super E> filter)
 */
public class TestPredicate {

    @Test
    public void test(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        //删除3的倍数
        /*list.remove(3);
        list.remove(6);
        list.remove(9);*/
        //这里会报下标越界，因为list中每删除一个下标就会重新从0开始。这里删除的并不是3的倍数
        //但只是这种思路而已，要删除只能这样

        /*Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer num = iterator.next();
            if (num % 3 == 0){
                iterator.remove();
            }
        }*/

        list.removeIf(t -> t % 3 == 0);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
