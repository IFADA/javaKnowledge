package com.java8;

import io.swagger.models.auth.In;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 方法引用:若Lambda体中的内容有方法已经事项了，我们可以使用方法引用
 * 主要有三种语法方式
 * <p>
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 */
public class MethdRef {
    @Test
    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);
        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;
    }

    @Test
    public void test2() {
        Comparator<Integer> com = Integer::compare;
        int compare = com.compare(6, 3);
        System.out.println(compare);
    }
}
