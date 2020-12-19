package com.thread;


public class ThreadLocalUserInfo {


    public static void main(String[] args) {
        new Service1().process();
    }

}

class Service1 {
    public void process() {
        User user = new User("超哥");
        UserContexHolder.userThreadLocal.set(user);
        new Service2().process();



    }
}
class Service2 {
    public void process() {
        User user = UserContexHolder.userThreadLocal.get();
        System.out.println("service2"+user.name);
        new Service3().process();

    }
}
class Service3 {
    public void process() {
        User user = UserContexHolder.userThreadLocal.get();
        System.out.println("service3"+user.name);

    }
}

class UserContexHolder {
    public static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }

}