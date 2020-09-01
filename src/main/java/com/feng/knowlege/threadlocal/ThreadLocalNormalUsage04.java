package com.feng.knowlege.threadlocal;

public class ThreadLocalNormalUsage04 {
    public static void main(String[] args) {
        Service1 service1 = new Service1();
        service1.process();

    }

}

class Service1{
    public void  process(){
        User user = new User("Jim");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}
class Service2{
    public void  process(){
        User user = UserContextHolder.holder.get();
        System.out.println(user.name);
        new Service3().process();
    }
}

class Service3{
    public void  process(){
        User user = UserContextHolder.holder.get();
        System.out.println(user.name);
    }
}








class UserContextHolder{
    public static  ThreadLocal<User> holder = new ThreadLocal<>();
}



class User{
    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}