package com.java8;

import org.junit.Test;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {

    List<Employee> employees = Arrays.asList(
            new Employee("Tom", 11, 5000),
            new Employee("jack", 33, 4444),
            new Employee("ni", 33, 4444443));

    public void test() {
        employees.stream().filter(employee -> employee.getAge() > 10).limit(2).skip(3).distinct();
    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList("aaaa", "bbb", "ddddd");
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPI::fiterCharater);//{{a,a,a},{b,b,b}}
        streamStream.forEach(System.out::println);
        System.out.println("-----------------------------");
        Stream<Character> characterStream = list.stream().flatMap(StreamAPI::fiterCharater);//{a,a,a,a,d,v,v,v}
        characterStream.forEach(System.out::println);

    }

    public static Stream<Character> fiterCharater(String string) {
        List<Character> list = new ArrayList<>();
        for (Character character : string.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

}
