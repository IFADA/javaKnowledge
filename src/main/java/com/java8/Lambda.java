package com.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {

    //Consumer<T>消费型接口
    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }
    @Test
    public void test1() {
        happy(1000, m -> System.out.println("消费:" + m + "元"));
    }




    //Supplier<T>供给型接口

    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }

    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer i : numList) {
            System.out.println(i);
        }
    }

    //Function<T,R>函数型接口

    public String strHandler(String string, Function<String, String> fun) {
        return fun.apply(string);
    }
    @Test
    public void test3() {
        String ddddddd = strHandler("ddddddd", x -> x.toUpperCase());
        System.out.println(ddddddd);

    }

    //Predicate<T> 断言型接口
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> stringList = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)) {
                stringList.add(str);
            }

        }
        return stringList;
    }

    @Test
    public void  test4(){
        List<String> before = Arrays.asList("hello","hi","ok");
        List<String> stringList = filterStr(before, str -> str.length() > 2);
        System.out.println(stringList);

    }


}
