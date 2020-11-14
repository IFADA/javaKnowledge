package com.design.pattern.creatianal.prototype.clone;

import java.util.Date;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date birthday = new Date(0L);
        Pig pig = new Pig("tom",birthday);
        Pig clone = (Pig) pig.clone();
         clone.getBirthday().setTime(666666666666L);
        System.out.println(pig);
        System.out.println(clone);
    }
}
