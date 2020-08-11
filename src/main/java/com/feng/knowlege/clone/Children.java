package com.feng.knowlege.clone;

import java.io.Serializable;

public class Children implements Serializable {
    private String name;
    private int age;
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Children(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Children() {

    }

    @Override
    public String toString() {
        return "Children{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
