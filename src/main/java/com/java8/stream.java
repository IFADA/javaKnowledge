package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class stream {
    public static void main(String[] args) {
        List<Integer> collect = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        List<Integer> collect1 = IntStream.range(10, 20).boxed().collect(Collectors.toList());
        List<Integer> collect2 = IntStream.range(30, 40).boxed().collect(Collectors.toList());
        String s = collect.stream().filter(item -> item > 5).findFirst().toString();
        List<List<Integer>> list = new ArrayList<>();
        list.add(collect);
        list.add(collect1);
        list.add(collect2);
        System.out.println(list);
        list.stream().collect(ArrayList::new,ArrayList::addAll,ArrayList::addAll);
    }

}
