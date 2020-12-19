package com.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPI2 {
    List<Employee> employees = Arrays.asList(
            new Employee("Tom", 11, 5000, Employee.Status.BUSY),
            new Employee("jack1", 23, 4444, Employee.Status.VOCATION),
            new Employee("jack2", 34, 4444, Employee.Status.VOCATION),
            new Employee("jack3", 36, 4444, Employee.Status.VOCATION),
            new Employee("jack4", 63, 4444, Employee.Status.VOCATION),
            new Employee("ni", 63, 4444443, Employee.Status.BUSY));


    @Test
    public void test1(){
        boolean b = employees.stream().allMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
    }
    @Test
    public void test2(){
        boolean b = employees.stream().anyMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
    }
    @Test
    public void test3(){
        Optional<Employee> first = employees.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(first.get());
    }
    @Test
    public void test4(){
        Optional<Employee> any = employees.parallelStream().filter(employee -> employee.getStatus().equals(Employee.Status.VOCATION)).findAny();
        System.out.println(any.get());

    }
    @Test
    public void test5(){
        long count = employees.stream().count();
        Optional<Employee> max = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max);

    }

    @Test
    public void test6(){
        Optional<Integer> reduce = employees.stream().map(Employee::getSalary).reduce(Integer::sum);
        System.out.println(reduce.get());

    }
    @Test
    public void test7(){
        List<Integer> collect = employees.stream().map(Employee::getAge).collect(Collectors.toList());
        System.out.println(collect);

    }
    @Test
    public void test8(){
        Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(collect);

    }


    @Test
    public void test9(){
        Map<Employee.Status, Map<String, List<Employee>>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
            if (e.getAge() <= 35) {
                return "青年";
            } else if (e.getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        System.out.println(collect);
    }
    @Test
    public void test10(){
        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy(e ->
                e.getAge() > 8000));
        System.out.println(collect);

    }


}
